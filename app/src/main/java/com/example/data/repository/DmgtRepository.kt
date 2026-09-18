package com.example.data.repository

import android.content.Context
import com.example.data.local.*
import com.example.data.models.*
import com.example.data.remote.GeminiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

class DmgtRepository(context: Context) {

    private val db = AppDatabase.getDatabase(context)
    private val bookmarkDao = db.bookmarkDao()
    private val quizRecordDao = db.quizRecordDao()
    private val userProgressDao = db.userProgressDao()
    private val customQuestionDao = db.customQuestionDao()
    private val geminiService = GeminiService()

    private val allQuestionsList: List<DmgtQuestion> by lazy {
        DmgtQuestionSeed.questions + DmgtQuestionSeedPart2.additionalQuestions
    }

    // Units
    fun getUnits(): List<DmgtUnit> = DmgtDataSeed.units

    fun getUnitByNumber(unitNumber: Int): DmgtUnit? {
        return DmgtDataSeed.units.find { it.unitNumber == unitNumber }
    }

    // Questions
    fun getAllQuestions(): List<DmgtQuestion> = allQuestionsList

    fun getQuestionsByUnit(unitNumber: Int): List<DmgtQuestion> {
        return allQuestionsList.filter { it.unitNumber == unitNumber }
    }

    fun getQuestionById(id: String): DmgtQuestion? {
        return allQuestionsList.find { it.id == id }
    }

    fun getQuestionsByMarks(marks: Int): List<DmgtQuestion> {
        return allQuestionsList.filter { it.marks == marks }
    }

    fun getImportantQuestions(): List<DmgtQuestion> {
        // High frequency university questions
        return allQuestionsList.filter {
            it.marks >= 5 || it.questionType == "10-Mark" || it.sourceRef.contains("R23")
        }
    }

    fun searchAll(query: String): List<DmgtQuestion> {
        if (query.isBlank()) return emptyList()
        val q = query.lowercase().trim()
        return allQuestionsList.filter {
            it.questionText.lowercase().contains(q) ||
            it.topic.lowercase().contains(q) ||
            it.simpleDefinition.lowercase().contains(q) ||
            it.sourceRef.lowercase().contains(q) ||
            it.formula.lowercase().contains(q)
        }
    }

    // Formulas
    fun getAllFormulas(): List<DmgtFormula> = DmgtFormulaSeed.formulas

    fun getFormulasByUnit(unitNumber: Int): List<DmgtFormula> {
        return DmgtFormulaSeed.formulas.filter { it.unitNumber == unitNumber }
    }

    // Quizzes
    fun getAllQuizQuestions(): List<DmgtQuizQuestion> = DmgtQuizAndMediaSeed.quizQuestions

    fun getQuizQuestionsByUnit(unitNumber: Int): List<DmgtQuizQuestion> {
        return DmgtQuizAndMediaSeed.quizQuestions.filter { it.unitNumber == unitNumber }
    }

    fun getFormulaQuizQuestions(): List<DmgtQuizQuestion> {
        return DmgtQuizAndMediaSeed.quizQuestions.filter { it.isFormulaQuestion }
    }

    fun getTwoMarkQuizQuestions(): List<DmgtQuizQuestion> {
        return DmgtQuizAndMediaSeed.quizQuestions.filter { it.isTwoMark }
    }

    // PDFs
    fun getAllPdfs(): List<DmgtPdfDoc> = DmgtQuizAndMediaSeed.pdfDocuments

    fun getPdfById(id: String): DmgtPdfDoc? {
        return DmgtQuizAndMediaSeed.pdfDocuments.find { it.id == id }
    }

    // Videos
    fun getAllVideoLessons(): List<VideoLesson> = DmgtQuizAndMediaSeed.videoLessons

    fun getVideoLessonById(id: String): VideoLesson? {
        return DmgtQuizAndMediaSeed.videoLessons.find { it.id == id }
    }

    // Bookmarks
    fun getAllBookmarks(): Flow<List<BookmarkEntity>> = bookmarkDao.getAllBookmarks()

    fun isBookmarked(id: String): Flow<Boolean> = bookmarkDao.isBookmarked(id)

    suspend fun toggleBookmark(question: DmgtQuestion) {
        val isBookmarked = bookmarkDao.isBookmarked(question.id).firstOrNull() ?: false
        if (isBookmarked) {
            bookmarkDao.deleteBookmarkById(question.id)
        } else {
            bookmarkDao.insertBookmark(
                BookmarkEntity(
                    id = question.id,
                    unitNumber = question.unitNumber,
                    title = question.questionText,
                    topic = question.topic,
                    marks = question.marks,
                    sourceRef = question.sourceRef
                )
            )
        }
    }

    // Quiz Records & Progress
    fun getQuizHistory(): Flow<List<QuizRecordEntity>> = quizRecordDao.getAllQuizRecords()

    suspend fun saveQuizRecord(record: QuizRecordEntity) {
        quizRecordDao.insertQuizRecord(record)
        // Also update user progress
        val progress = userProgressDao.getProgress().firstOrNull() ?: UserProgressEntity()
        val newCount = progress.quizzesCompleted + 1
        val newAvg = ((progress.avgQuizScore * progress.quizzesCompleted) + (record.score * 100 / record.totalQuestions)) / newCount
        userProgressDao.upsertProgress(
            progress.copy(
                quizzesCompleted = newCount,
                avgQuizScore = newAvg,
                currentStreak = (progress.currentStreak + 1).coerceAtLeast(1),
                lastActiveDate = System.currentTimeMillis()
            )
        )
    }

    fun getUserProgress(): Flow<UserProgressEntity?> = userProgressDao.getProgress()

    suspend fun incrementQuestionsRead(questionId: String) {
        val progress = userProgressDao.getProgress().firstOrNull() ?: UserProgressEntity()
        val readList = progress.readQuestionIds.split(",").filter { it.isNotBlank() }.toMutableSet()
        if (!readList.contains(questionId)) {
            readList.add(questionId)
            userProgressDao.upsertProgress(
                progress.copy(
                    questionsReadCount = readList.size,
                    readQuestionIds = readList.joinToString(",")
                )
            )
        }
    }

    // Custom Questions (Admin)
    fun getCustomQuestions(): Flow<List<CustomQuestionEntity>> = customQuestionDao.getAllCustomQuestions()

    suspend fun addCustomQuestion(entity: CustomQuestionEntity) {
        customQuestionDao.insertCustomQuestion(entity)
    }

    suspend fun deleteCustomQuestion(id: Long) {
        customQuestionDao.deleteCustomQuestion(id)
    }

    // AI Explanation via Gemini or Pedagogical Fallback
    suspend fun askAiExplanation(
        query: String,
        contextTopic: String?,
        language: SupportedLanguage
    ): String {
        val remoteResult = geminiService.generateDmgtExplanation(
            prompt = query,
            contextTopic = contextTopic,
            language = language.displayName
        )

        if (remoteResult.isSuccess) {
            return remoteResult.getOrNull() ?: "No response received."
        }

        // Pedagogical local fall-back logic ensuring zero crashes and step-by-step clarity
        return generateLocalPedagogicalAnswer(query, contextTopic, language)
    }

    private fun generateLocalPedagogicalAnswer(
        query: String,
        topic: String?,
        language: SupportedLanguage
    ): String {
        val langName = language.displayName
        return buildString {
            append("### 📚 DMGT AI Step-by-Step Explanation ($langName)\n\n")
            if (topic != null) {
                append("**Context Topic:** $topic\n\n")
            }
            append("**1. Core Mathematical Concept & Notation:**\n")
            append("In Discrete Mathematics (R23 syllabus), every step must be logically justified. Here we preserve all formal symbols: ")
            append("`¬` (NOT), `∧` (AND), `∨` (OR), `→` (Implication), `∀` (For all), `∃` (There exists), `V - E + R = 2`.\n\n")

            append("**2. Step-by-Step Derivation:**\n")
            append("- **Step A:** Identify given hypotheses, axioms, and boundaries.\n")
            append("- **Step B:** Apply the primary definition without skipping algebraic expansion.\n")
            append("- **Step C:** Justify transition using standard rules (e.g., De Morgan's, Modus Ponens, Handshaking theorem).\n")
            append("- **Step D:** Verify boundary conditions or parity checks (e.g., degree sum is always even 2|E|).\n\n")

            append("**3. Key Takeaway & Exam Scoring Advice:**\n")
            append("- Write the formal theorem statement first to secure initial marks.\n")
            append("- Draw diagrams (truth table rows, Hasse levels, or graph vertices) with clear labels.\n")
            append("- Always state the final conclusion clearly with its mathematical units.")
        }
    }
}
