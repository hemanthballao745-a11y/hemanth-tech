package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.viewmodel.DmgtViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminScreen(
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val customQuestions by viewModel.customQuestions.collectAsState()

    var unitNumberText by remember { mutableStateOf("1") }
    var questionText by remember { mutableStateOf("") }
    var answerText by remember { mutableStateOf("") }
    var marksText by remember { mutableStateOf("5") }
    var topicText by remember { mutableStateOf("") }
    var formulaText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Faculty / Admin Question Bank", fontWeight = FontWeight.Bold) },
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
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Add Custom Question to DMGT Bank",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            OutlinedTextField(
                                value = unitNumberText,
                                onValueChange = { unitNumberText = it },
                                label = { Text("Unit (1-5)") },
                                modifier = Modifier.weight(1f),
                                singleLine = true
                            )
                            OutlinedTextField(
                                value = marksText,
                                onValueChange = { marksText = it },
                                label = { Text("Marks (2/5/10)") },
                                modifier = Modifier.weight(1f),
                                singleLine = true
                            )
                        }

                        OutlinedTextField(
                            value = topicText,
                            onValueChange = { topicText = it },
                            label = { Text("Topic Name") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )

                        OutlinedTextField(
                            value = formulaText,
                            onValueChange = { formulaText = it },
                            label = { Text("Primary Formula / Theorem") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )

                        OutlinedTextField(
                            value = questionText,
                            onValueChange = { questionText = it },
                            label = { Text("Question Statement") },
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 3
                        )

                        OutlinedTextField(
                            value = answerText,
                            onValueChange = { answerText = it },
                            label = { Text("Step-by-Step Answer / Solution") },
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 4
                        )

                        Button(
                            onClick = {
                                val unit = unitNumberText.toIntOrNull() ?: 1
                                val marks = marksText.toIntOrNull() ?: 5
                                if (questionText.isBlank() || answerText.isBlank()) {
                                    Toast.makeText(context, "Please fill question and answer.", Toast.LENGTH_SHORT).show()
                                    return@Button
                                }
                                viewModel.addAdminQuestion(
                                    unit = unit,
                                    question = questionText,
                                    answer = answerText,
                                    marks = marks,
                                    topic = topicText.ifBlank { "General DMGT" },
                                    formula = formulaText.ifBlank { "N/A" }
                                )
                                questionText = ""
                                answerText = ""
                                topicText = ""
                                formulaText = ""
                                Toast.makeText(context, "Question added successfully!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("Publish Question to Local Database")
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Custom Questions Added (${customQuestions.size})",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            if (customQuestions.isEmpty()) {
                item {
                    Text(
                        text = "No custom questions added yet.",
                        color = MaterialTheme.colorScheme.outline,
                        fontSize = 13.sp
                    )
                }
            } else {
                items(customQuestions) { cq ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Unit ${cq.unitNumber} • ${cq.marks} Marks • ${cq.topic}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = cq.questionText,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            IconButton(onClick = { viewModel.deleteAdminQuestion(cq.id) }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
