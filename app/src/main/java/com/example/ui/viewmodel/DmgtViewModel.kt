package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.BookmarkEntity
import com.example.data.local.CustomQuestionEntity
import com.example.data.local.QuizRecordEntity
import com.example.data.local.UserProgressEntity
import com.example.data.models.*
import com.example.data.repository.DmgtRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class AuthUiState(
    val isLoggedIn: Boolean = false,
    val isGuest: Boolean = false,
    val userEmail: String = "",
    val userName: String = "",
    val rollNumber: String = "",
    val college: String = "",
    val isAdmin: Boolean = false,
    val errorMessage: String? = null
)

data class QuizUiState(
    val isActive: Boolean = false,
    val unitNumber: Int? = null,
    val title: String = "DMGT Practice Quiz",
    val questions: List<DmgtQuizQuestion> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val isAnswerChecked: Boolean = false,
    val score: Int = 0,
    val isFinished: Boolean = false
)

data class AiDoubtState(
    val isLoading: Boolean = false,
    val query: String = "",
    val response: String? = null,
    val errorMessage: String? = null
)

class DmgtViewModel(application: Application) : AndroidViewModel(application) {

    val repository = DmgtRepository(application)

    // Auth State (Default guest preview so user can explore immediately)
    private val _authState = MutableStateFlow(
        AuthUiState(
            isLoggedIn = true,
            isGuest = true,
            userName = "Student (Guest)",
            userEmail = "guest@dmgt.edu",
            rollNumber = "R23-DEMO-01",
            college = "Engineering College"
        )
    )
    val authState: StateFlow<AuthUiState> = _authState.asStateFlow()

    // Selected Language
    private val _selectedLanguage = MutableStateFlow(SupportedLanguage.ENGLISH)
    val selectedLanguage: StateFlow<SupportedLanguage> = _selectedLanguage.asStateFlow()

    // Global Search
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<DmgtQuestion>>(emptyList())
    val searchResults: StateFlow<List<DmgtQuestion>> = _searchResults.asStateFlow()

    // Bookmarks
    val bookmarks: StateFlow<List<BookmarkEntity>> = repository.getAllBookmarks()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Progress
    val userProgress: StateFlow<UserProgressEntity?> = repository.getUserProgress()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    // Quiz History
    val quizHistory: StateFlow<List<QuizRecordEntity>> = repository.getQuizHistory()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Active Quiz State
    private val _quizState = MutableStateFlow(QuizUiState())
    val quizState: StateFlow<QuizUiState> = _quizState.asStateFlow()

    // AI Doubt State
    private val _aiDoubtState = MutableStateFlow(AiDoubtState())
    val aiDoubtState: StateFlow<AiDoubtState> = _aiDoubtState.asStateFlow()

    // Custom Questions
    val customQuestions: StateFlow<List<CustomQuestionEntity>> = repository.getCustomQuestions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Auth Functions
    fun login(email: String, name: String, rollNo: String, collegeName: String, isAdminUser: Boolean = false) {
        _authState.value = AuthUiState(
            isLoggedIn = true,
            isGuest = false,
            userEmail = email,
            userName = name.ifBlank { "DMGT Scholar" },
            rollNumber = rollNo.ifBlank { "R23-2024" },
            college = collegeName.ifBlank { "Engineering Institute" },
            isAdmin = isAdminUser || email.contains("admin", ignoreCase = true)
        )
    }

    fun continueAsGuest() {
        _authState.value = AuthUiState(
            isLoggedIn = true,
            isGuest = true,
            userName = "Guest Scholar",
            userEmail = "guest@dmgt.edu",
            rollNumber = "GUEST-PREVIEW",
            college = "Engineering College"
        )
    }

    fun logout() {
        _authState.value = AuthUiState(isLoggedIn = false)
    }

    fun setLanguage(lang: SupportedLanguage) {
        _selectedLanguage.value = lang
    }

    // Search
    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        _searchResults.value = repository.searchAll(query)
    }

    // Bookmarks
    fun isQuestionBookmarked(questionId: String): Flow<Boolean> {
        return repository.isBookmarked(questionId)
    }

    fun toggleBookmark(question: DmgtQuestion) {
        viewModelScope.launch {
            repository.toggleBookmark(question)
        }
    }

    fun markQuestionRead(questionId: String) {
        viewModelScope.launch {
            repository.incrementQuestionsRead(questionId)
        }
    }

    // Quiz Functions
    fun startQuiz(unitNumber: Int? = null, isFormulaOnly: Boolean = false, isTwoMarkOnly: Boolean = false) {
        val questions = when {
            isFormulaOnly -> repository.getFormulaQuizQuestions()
            isTwoMarkOnly -> repository.getTwoMarkQuizQuestions()
            unitNumber != null -> repository.getQuizQuestionsByUnit(unitNumber)
            else -> repository.getAllQuizQuestions()
        }.shuffled().take(10)

        val title = when {
            isFormulaOnly -> "Formula Mastery Quiz"
            isTwoMarkOnly -> "2-Mark Rapid Quiz"
            unitNumber != null -> "Unit $unitNumber Quiz"
            else -> "Comprehensive DMGT Quiz"
        }

        _quizState.value = QuizUiState(
            isActive = true,
            unitNumber = unitNumber,
            title = title,
            questions = questions,
            currentIndex = 0,
            selectedOptionIndex = null,
            isAnswerChecked = false,
            score = 0,
            isFinished = false
        )
    }

    fun selectQuizOption(index: Int) {
        if (_quizState.value.isAnswerChecked) return
        _quizState.value = _quizState.value.copy(selectedOptionIndex = index)
    }

    fun checkQuizAnswer() {
        val current = _quizState.value
        if (current.selectedOptionIndex == null) return
        val currentQ = current.questions.getOrNull(current.currentIndex) ?: return
        val isCorrect = current.selectedOptionIndex == currentQ.correctOptionIndex
        val newScore = if (isCorrect) current.score + 1 else current.score

        _quizState.value = current.copy(
            isAnswerChecked = true,
            score = newScore
        )
    }

    fun nextQuizQuestion() {
        val current = _quizState.value
        val nextIndex = current.currentIndex + 1
        if (nextIndex < current.questions.size) {
            _quizState.value = current.copy(
                currentIndex = nextIndex,
                selectedOptionIndex = null,
                isAnswerChecked = false
            )
        } else {
            // Finish quiz & save record
            _quizState.value = current.copy(isFinished = true)
            viewModelScope.launch {
                repository.saveQuizRecord(
                    QuizRecordEntity(
                        quizTitle = current.title,
                        score = current.score,
                        totalQuestions = current.questions.size,
                        unitNumber = current.unitNumber ?: 0
                    )
                )
            }
        }
    }

    // AI Doubt Resolution
    fun askAiDoubt(query: String, contextTopic: String? = null) {
        if (query.isBlank()) return
        _aiDoubtState.value = AiDoubtState(isLoading = true, query = query)
        viewModelScope.launch {
            try {
                val answer = repository.askAiExplanation(
                    query = query,
                    contextTopic = contextTopic,
                    language = _selectedLanguage.value
                )
                _aiDoubtState.value = AiDoubtState(
                    isLoading = false,
                    query = query,
                    response = answer
                )
            } catch (e: Exception) {
                _aiDoubtState.value = AiDoubtState(
                    isLoading = false,
                    query = query,
                    errorMessage = e.message ?: "Failed to get AI response"
                )
            }
        }
    }

    fun clearAiDoubt() {
        _aiDoubtState.value = AiDoubtState()
    }

    // Admin Add Question
    fun addAdminQuestion(
        unit: Int,
        question: String,
        answer: String,
        marks: Int,
        topic: String,
        formula: String
    ) {
        viewModelScope.launch {
            repository.addCustomQuestion(
                CustomQuestionEntity(
                    unitNumber = unit,
                    questionText = question,
                    answer = answer,
                    marks = marks,
                    topic = topic,
                    formula = formula,
                    questionType = "${marks}-Mark"
                )
            )
        }
    }

    fun deleteAdminQuestion(id: Long) {
        viewModelScope.launch {
            repository.deleteCustomQuestion(id)
        }
    }
}
