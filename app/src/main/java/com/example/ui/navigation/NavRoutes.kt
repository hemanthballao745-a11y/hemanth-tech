package com.example.ui.navigation

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Home : Screen("home")
    object UnitDetail : Screen("unit/{unitNumber}") {
        fun createRoute(unitNumber: Int) = "unit/$unitNumber"
    }
    object QuestionDetail : Screen("question/{questionId}") {
        fun createRoute(questionId: String) = "question/$questionId"
    }
    object ImportantQuestions : Screen("important_questions")
    object TwoMarkQuestions : Screen("two_mark_questions")
    object LongQuestions : Screen("long_questions")
    object FormulaBank : Screen("formula_bank")
    object Quiz : Screen("quiz")
    object PracticeMode : Screen("practice_mode")
    object VideoLessons : Screen("video_lessons")
    object PdfViewer : Screen("pdf_viewer/{pdfId}") {
        fun createRoute(pdfId: String) = "pdf_viewer/$pdfId"
    }
    object Bookmarks : Screen("bookmarks")
    object Search : Screen("search")
    object Profile : Screen("profile")
    object Admin : Screen("admin")
    object GraphVisualizer : Screen("graph_visualizer")
}
