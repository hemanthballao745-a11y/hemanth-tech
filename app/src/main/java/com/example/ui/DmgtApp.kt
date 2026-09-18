package com.example.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.navigation.Screen
import com.example.ui.screens.*
import com.example.ui.viewmodel.DmgtViewModel

@Composable
fun DmgtApp(viewModel: DmgtViewModel = viewModel()) {
    val navController = rememberNavController()
    val authState by viewModel.authState.collectAsState()

    val startDestination = if (authState.isLoggedIn) Screen.Home.route else Screen.Auth.route

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.Auth.route) {
            AuthScreen(
                viewModel = viewModel,
                onAuthSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Auth.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = viewModel,
                onNavigateToUnit = { unitNo ->
                    navController.navigate(Screen.UnitDetail.createRoute(unitNo))
                },
                onNavigateToImportantQuestions = {
                    navController.navigate(Screen.ImportantQuestions.route)
                },
                onNavigateToTwoMark = {
                    navController.navigate(Screen.TwoMarkQuestions.route)
                },
                onNavigateToLongQuestions = {
                    navController.navigate(Screen.LongQuestions.route)
                },
                onNavigateToFormulas = {
                    navController.navigate(Screen.FormulaBank.route)
                },
                onNavigateToQuiz = {
                    navController.navigate(Screen.Quiz.route)
                },
                onNavigateToPractice = {
                    navController.navigate(Screen.PracticeMode.route)
                },
                onNavigateToVideos = {
                    navController.navigate(Screen.VideoLessons.route)
                },
                onNavigateToPdf = { pdfId ->
                    navController.navigate(Screen.PdfViewer.createRoute(pdfId))
                },
                onNavigateToBookmarks = {
                    navController.navigate(Screen.Bookmarks.route)
                },
                onNavigateToSearch = {
                    navController.navigate(Screen.Search.route)
                },
                onNavigateToProfile = {
                    navController.navigate(Screen.Profile.route)
                },
                onNavigateToGraphVisualizer = {
                    navController.navigate(Screen.GraphVisualizer.route)
                },
                onNavigateToAdmin = {
                    navController.navigate(Screen.Admin.route)
                }
            )
        }

        composable(
            route = Screen.UnitDetail.route,
            arguments = listOf(navArgument("unitNumber") { type = NavType.IntType })
        ) { backStackEntry ->
            val unitNumber = backStackEntry.arguments?.getInt("unitNumber") ?: 1
            UnitDetailScreen(
                unitNumber = unitNumber,
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuestion = { qId ->
                    navController.navigate(Screen.QuestionDetail.createRoute(qId))
                }
            )
        }

        composable(
            route = Screen.QuestionDetail.route,
            arguments = listOf(navArgument("questionId") { type = NavType.StringType })
        ) { backStackEntry ->
            val questionId = backStackEntry.arguments?.getString("questionId") ?: ""
            QuestionDetailScreen(
                questionId = questionId,
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.ImportantQuestions.route) {
            ImportantQuestionsScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuestion = { qId ->
                    navController.navigate(Screen.QuestionDetail.createRoute(qId))
                }
            )
        }

        composable(Screen.TwoMarkQuestions.route) {
            TwoMarkQuestionsScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuestion = { qId ->
                    navController.navigate(Screen.QuestionDetail.createRoute(qId))
                }
            )
        }

        composable(Screen.LongQuestions.route) {
            LongQuestionsScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuestion = { qId ->
                    navController.navigate(Screen.QuestionDetail.createRoute(qId))
                }
            )
        }

        composable(Screen.PracticeMode.route) {
            PracticeModeScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuestion = { qId ->
                    navController.navigate(Screen.QuestionDetail.createRoute(qId))
                }
            )
        }

        composable(Screen.FormulaBank.route) {
            FormulaBankScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Quiz.route) {
            QuizScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.VideoLessons.route) {
            VideoLessonsScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.PdfViewer.route,
            arguments = listOf(navArgument("pdfId") { type = NavType.StringType })
        ) { backStackEntry ->
            val pdfId = backStackEntry.arguments?.getString("pdfId") ?: "pdf_qb_r23"
            PdfViewerScreen(
                pdfId = pdfId,
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Bookmarks.route) {
            BookmarksScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuestion = { qId ->
                    navController.navigate(Screen.QuestionDetail.createRoute(qId))
                }
            )
        }

        composable(Screen.Search.route) {
            SearchScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuestion = { qId ->
                    navController.navigate(Screen.QuestionDetail.createRoute(qId))
                }
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onLogout = {
                    navController.navigate(Screen.Auth.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Admin.route) {
            AdminScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.GraphVisualizer.route) {
            GraphVisualizerScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
