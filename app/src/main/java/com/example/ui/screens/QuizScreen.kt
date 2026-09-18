package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.viewmodel.DmgtViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit
) {
    val quizState by viewModel.quizState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (quizState.isActive) quizState.title else "DMGT Quiz & Practice",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (!quizState.isActive) {
                // Quiz Category Selection Screen
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "Test Your DMGT Exam Readiness",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Instant scoring, detailed step-by-step solutions, and streak tracking.",
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    item {
                        Text(
                            text = "Special Practice Modes",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }

                    item {
                        QuizSelectionCard(
                            title = "Formula Mastery Quiz",
                            subtitle = "Laws, equivalents, Euler's formula, Handshaking",
                            icon = Icons.Default.Functions,
                            onClick = { viewModel.startQuiz(isFormulaOnly = true) }
                        )
                    }

                    item {
                        QuizSelectionCard(
                            title = "2-Mark Rapid Quiz",
                            subtitle = "Core definitions, theorems, and short numericals",
                            icon = Icons.Default.FlashOn,
                            onClick = { viewModel.startQuiz(isTwoMarkOnly = true) }
                        )
                    }

                    item {
                        QuizSelectionCard(
                            title = "Full Comprehensive Quiz (All Units)",
                            subtitle = "Random mix from entire R23 question bank",
                            icon = Icons.Default.WorkspacePremium,
                            onClick = { viewModel.startQuiz(unitNumber = null) }
                        )
                    }

                    item {
                        Text(
                            text = "Unit-Wise Quizzes",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        )
                    }

                    items(5) { index ->
                        val unitNo = index + 1
                        val unitTitle = when (unitNo) {
                            1 -> "Unit 1: Mathematical Logic"
                            2 -> "Unit 2: Set Theory & Relations"
                            3 -> "Unit 3: Combinatorics & Recurrence"
                            4 -> "Unit 4: Graph Theory Basics"
                            else -> "Unit 5: Multigraphs & Trees"
                        }
                        QuizSelectionCard(
                            title = unitTitle,
                            subtitle = "10 Targeted Questions from R23 Syllabus",
                            icon = Icons.Default.CheckCircleOutline,
                            onClick = { viewModel.startQuiz(unitNumber = unitNo) }
                        )
                    }
                }
            } else if (quizState.isFinished) {
                // Quiz Results Card
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.EmojiEvents,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(64.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Quiz Completed!",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Your Score: ${quizState.score} / ${quizState.questions.size}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            val percentage = if (quizState.questions.isNotEmpty()) (quizState.score * 100 / quizState.questions.size) else 0
                            Text(
                                text = "Accuracy: $percentage%",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = if (percentage >= 80) "Excellent! You have solid command of this topic."
                                else if (percentage >= 50) "Good work! Review the step-by-step explanations to reach 100%."
                                else "Keep practicing! Review the Formula Bank and Unit Notes.",
                                textAlign = TextAlign.Center,
                                fontSize = 13.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { viewModel.startQuiz(unitNumber = quizState.unitNumber) },
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Retake Quiz", fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedButton(
                        onClick = onNavigateBack,
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Back to Dashboard")
                    }
                }
            } else {
                // Active Quiz Question View
                val currentQ = quizState.questions.getOrNull(quizState.currentIndex)
                if (currentQ != null) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(14.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            // Progress bar & index
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Question ${quizState.currentIndex + 1} of ${quizState.questions.size}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "Score: ${quizState.score}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }

                            LinearProgressIndicator(
                                progress = { (quizState.currentIndex + 1).toFloat() / quizState.questions.size },
                                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
                            )

                            // Question Card
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(
                                        text = "Topic: ${currentQ.topic}",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = currentQ.question,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        lineHeight = 22.sp
                                    )
                                }
                            }

                            // Options List
                            currentQ.options.forEachIndexed { optIndex, optionText ->
                                val isSelected = quizState.selectedOptionIndex == optIndex
                                val isChecked = quizState.isAnswerChecked
                                val isCorrect = optIndex == currentQ.correctOptionIndex

                                val borderColor = when {
                                    isChecked && isCorrect -> Color(0xFF2E7D32)
                                    isChecked && isSelected && !isCorrect -> MaterialTheme.colorScheme.error
                                    isSelected -> MaterialTheme.colorScheme.primary
                                    else -> MaterialTheme.colorScheme.outlineVariant
                                }

                                val containerColor = when {
                                    isChecked && isCorrect -> Color(0xFFE8F5E9)
                                    isChecked && isSelected && !isCorrect -> MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.4f)
                                    isSelected -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                                    else -> MaterialTheme.colorScheme.surface
                                }

                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .clickable(enabled = !isChecked) {
                                            viewModel.selectQuizOption(optIndex)
                                        },
                                    shape = RoundedCornerShape(10.dp),
                                    border = BorderStroke(if (isSelected || isChecked) 2.dp else 1.dp, borderColor),
                                    color = containerColor
                                ) {
                                    Row(
                                        modifier = Modifier.padding(14.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "${('A' + optIndex)}. ",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp,
                                            color = borderColor
                                        )
                                        Text(
                                            text = optionText,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Medium,
                                            modifier = Modifier.weight(1f)
                                        )
                                        if (isChecked) {
                                            if (isCorrect) {
                                                Icon(
                                                    imageVector = Icons.Default.CheckCircle,
                                                    contentDescription = "Correct",
                                                    tint = Color(0xFF2E7D32)
                                                )
                                            } else if (isSelected) {
                                                Icon(
                                                    imageVector = Icons.Default.Cancel,
                                                    contentDescription = "Incorrect",
                                                    tint = MaterialTheme.colorScheme.error
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                            // Pedagogical Explanation Box when answered
                            if (quizState.isAnswerChecked) {
                                Surface(
                                    color = MaterialTheme.colorScheme.surfaceVariant,
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Text(
                                            text = "Explanation:",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(
                                            text = currentQ.explanation,
                                            fontSize = 12.sp,
                                            lineHeight = 17.sp
                                        )
                                    }
                                }
                            }
                        }

                        // Bottom Action Button
                        if (!quizState.isAnswerChecked) {
                            Button(
                                onClick = { viewModel.checkQuizAnswer() },
                                modifier = Modifier.fillMaxWidth().height(48.dp),
                                enabled = quizState.selectedOptionIndex != null,
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text("Check Answer", fontWeight = FontWeight.Bold)
                            }
                        } else {
                            Button(
                                onClick = { viewModel.nextQuizQuestion() },
                                modifier = Modifier.fillMaxWidth().height(48.dp),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    text = if (quizState.currentIndex == quizState.questions.size - 1) "View Results" else "Next Question →",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuizSelectionCard(
    title: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(22.dp)
                )
            }
            Spacer(modifier = Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.outline
            )
        }
    }
}
