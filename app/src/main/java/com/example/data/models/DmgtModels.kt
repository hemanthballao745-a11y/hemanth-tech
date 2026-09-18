package com.example.data.models

data class DmgtUnit(
    val unitNumber: Int,
    val title: String,
    val subtitle: String,
    val description: String,
    val topics: List<DmgtTopic>,
    val questionCount: Int,
    val formulaCount: Int
)

data class DmgtTopic(
    val id: String,
    val unitNumber: Int,
    val title: String,
    val summary: String,
    val keyConcepts: List<String>,
    val coreFormulas: List<String>
)

data class DmgtQuestion(
    val id: String,
    val unitNumber: Int,
    val unitTitle: String,
    val sourceRef: String,
    val questionText: String,
    val marks: Int,
    val questionType: String, // "2-Mark", "5-Mark", "10-Mark", "Definition", "Problem", "Proof", "Algorithm", "Repeated"
    val difficulty: String, // "Easy", "Medium", "Hard"
    val topic: String,
    val simpleDefinition: String,
    val formula: String,
    val symbolMeanings: List<Pair<String, String>>,
    val lineByLineExplanation: List<String>,
    val stepByStepSolution: List<String>,
    val whyStepUsed: List<String>,
    val easyExample: String,
    val examStyleExample: String,
    val twoMarkAnswer: String,
    val fiveMarkAnswer: String,
    val tenMarkAnswer: String,
    val commonMistakes: List<String>,
    val finalAnswer: String,
    val shortcutTip: String,
    val similarPracticeQuestion: String,
    val hasGraphDiagram: Boolean = false,
    val graphDiagramType: String = "" // "bipartite", "cycle", "tree", "matrix", "hasse"
)

data class DmgtFormula(
    val id: String,
    val unitNumber: Int,
    val name: String,
    val category: String,
    val formula: String,
    val symbolBreakdown: List<Pair<String, String>>,
    val whenToUse: String,
    val example: String,
    val stepByStep: List<String>,
    val commonMistake: String
)

data class DmgtQuizQuestion(
    val id: String,
    val unitNumber: Int,
    val topic: String,
    val question: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanation: String,
    val isTwoMark: Boolean = false,
    val isFormulaQuestion: Boolean = false
)

data class DmgtPdfDoc(
    val id: String,
    val title: String,
    val unitNumber: Int?,
    val type: String,
    val description: String,
    val pageCount: Int,
    val contentMarkdown: String
)

data class VideoLesson(
    val id: String,
    val unitNumber: Int,
    val title: String,
    val durationSec: Int,
    val slides: List<VideoSlide>
)

data class VideoSlide(
    val slideNumber: Int,
    val title: String,
    val formula: String,
    val bulletPoints: List<String>,
    val narrationEn: String,
    val narrationTe: String,
    val narrationHi: String,
    val diagramHint: String = ""
)

enum class SupportedLanguage(val code: String, val displayName: String, val nativeName: String) {
    ENGLISH("en", "English", "English"),
    TELUGU("te", "Telugu", "తెలుగు"),
    HINDI("hi", "Hindi", "हिंदी"),
    TAMIL("ta", "Tamil", "தமிழ்"),
    KANNADA("kn", "Kannada", "ಕನ್ನಡ"),
    MALAYALAM("ml", "Malayalam", "മലയാളം"),
    MARATHI("mr", "Marathi", "मराठी"),
    BENGALI("bn", "Bengali", "বাংলা"),
    GUJARATI("gu", "Gujarati", "ગુજરાતી"),
    PUNJABI("pa", "Punjabi", "ਪੰਜਾਬੀ"),
    URDU("ur", "Urdu", "اردو")
}

data class UserSession(
    val email: String,
    val fullName: String,
    val rollNumber: String,
    val college: String,
    val isGuest: Boolean,
    val isAdmin: Boolean
)
