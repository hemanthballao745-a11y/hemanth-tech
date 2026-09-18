package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.viewmodel.DmgtViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportantQuestionsScreen(
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToQuestion: (String) -> Unit
) {
    val questions = remember { viewModel.repository.getImportantQuestions() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("R23 Important Exam Questions", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "High-Probability R23 University Questions",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "These questions have repeated most frequently across semester end examinations.",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            items(questions) { q ->
                QuestionListItemCard(
                    question = q,
                    onClick = { onNavigateToQuestion(q.id) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoMarkQuestionsScreen(
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToQuestion: (String) -> Unit
) {
    val questions = remember { viewModel.repository.getQuestionsByMarks(2) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("2-Mark Short Answer Questions", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(questions) { q ->
                QuestionListItemCard(
                    question = q,
                    onClick = { onNavigateToQuestion(q.id) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LongQuestionsScreen(
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToQuestion: (String) -> Unit
) {
    val questions = remember {
        viewModel.repository.getQuestionsByMarks(5) + viewModel.repository.getQuestionsByMarks(10)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("5 & 10-Mark Detailed Derivations", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(questions) { q ->
                QuestionListItemCard(
                    question = q,
                    onClick = { onNavigateToQuestion(q.id) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeModeScreen(
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToQuestion: (String) -> Unit
) {
    val allQuestions = remember { viewModel.repository.getAllQuestions() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exam Practice: 2/5/10 Mark Formatter", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Exam Answer Writing Practice",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Select any question to see how to format its solution for 2 marks (concise), 5 marks (analytical), or 10 marks (complete academic proof).",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            items(allQuestions) { q ->
                QuestionListItemCard(
                    question = q,
                    onClick = { onNavigateToQuestion(q.id) }
                )
            }
        }
    }
}
