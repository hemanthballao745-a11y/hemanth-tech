package com.example.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.SupportedLanguage
import com.example.ui.viewmodel.DmgtViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionDetailScreen(
    questionId: String,
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val question = remember(questionId) { viewModel.repository.getQuestionById(questionId) }
    val isBookmarked by viewModel.isQuestionBookmarked(questionId).collectAsState(initial = false)
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()
    val aiDoubtState by viewModel.aiDoubtState.collectAsState()

    var selectedExamAnswerTab by remember { mutableStateOf(if ((question?.marks ?: 2) == 10) 2 else if ((question?.marks ?: 2) == 5) 1 else 0) }
    var showAiBottomSheet by remember { mutableStateOf(false) }
    var userDoubtInput by remember { mutableStateOf("") }
    var showLanguageMenu by remember { mutableStateOf(false) }

    LaunchedEffect(questionId) {
        viewModel.markQuestionRead(questionId)
    }

    if (question == null) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Question Not Found") },
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Requested question could not be found.")
            }
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Unit ${question.unitNumber} Solution",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = question.sourceRef,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    // Language Switcher
                    IconButton(onClick = { showLanguageMenu = true }) {
                        Icon(Icons.Default.Translate, contentDescription = "Select Language")
                    }

                    // Bookmark Button
                    IconButton(
                        onClick = { viewModel.toggleBookmark(question) },
                        modifier = Modifier.testTag("bookmark_toggle_button")
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = if (isBookmarked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // Share Button
                    IconButton(
                        onClick = {
                            val shareIntent = Intent().apply {
                                action = Intent.ACTION_SEND
                                type = "text/plain"
                                putExtra(
                                    Intent.EXTRA_TEXT,
                                    "DMGT R23 Question [${question.sourceRef}]:\n\n${question.questionText}\n\nFormula: ${question.formula}\n\nFinal Answer: ${question.finalAnswer}\n\nStudied via DMGT AI Study Assistant"
                                )
                            }
                            context.startActivity(Intent.createChooser(shareIntent, "Share Question & Solution"))
                        }
                    ) {
                        Icon(Icons.Default.Share, contentDescription = "Share Question")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    userDoubtInput = "Explain this step-by-step: ${question.questionText}"
                    showAiBottomSheet = true
                },
                icon = { Icon(Icons.Default.AutoAwesome, contentDescription = null) },
                text = { Text("Ask AI Tutor") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.testTag("ask_ai_fab")
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Source & Tags Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = question.sourceRef,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Badge {
                                Text("${question.marks} MARKS • ${question.difficulty.uppercase()}")
                            }
                        }

                        Text(
                            text = question.questionText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = "Topic: ${question.topic}",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // 1. Simple Definition
            item {
                SectionCard(
                    title = "1. Simple Definition & Intuition",
                    icon = Icons.Default.Info
                ) {
                    Text(
                        text = question.simpleDefinition,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // 2. Formula & Symbol-by-Symbol Breakdown Table
            item {
                SectionCard(
                    title = "2. Formula & Symbol Meanings",
                    icon = Icons.Default.Functions
                ) {
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = question.formula,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(12.dp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Symbol-by-Symbol Breakdown:",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp
                    )

                    question.symbolMeanings.forEach { (symbol, meaning) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = symbol,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 13.sp,
                                modifier = Modifier.width(72.dp)
                            )
                            Text(
                                text = meaning,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            // 3. Line-by-Line Explanation
            item {
                SectionCard(
                    title = "3. Line-by-Line Logical Explanation",
                    icon = Icons.Default.FormatListNumbered
                ) {
                    question.lineByLineExplanation.forEach { line ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(text = "•", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                            Text(
                                text = line,
                                fontSize = 13.sp,
                                lineHeight = 19.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            // 4 & 5. Step-by-Step Solution & Why Step Was Used
            item {
                SectionCard(
                    title = "4 & 5. Step-by-Step Derivation & Justification",
                    icon = Icons.Default.Checklist
                ) {
                    question.stepByStepSolution.forEachIndexed { index, step ->
                        Surface(
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = step,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Medium,
                                    lineHeight = 18.sp
                                )
                                val why = question.whyStepUsed.getOrNull(index)
                                if (why != null) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Why this step? $why",
                                        fontSize = 11.sp,
                                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 6 & 7. Examples (Easy & Exam-style)
            item {
                SectionCard(
                    title = "6 & 7. Intuition & Exam Examples",
                    icon = Icons.Default.Lightbulb
                ) {
                    Text(
                        text = "Easy Intuition Example:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = question.easyExample,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Exam-Style Presentation:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = question.examStyleExample,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // 8. Exam Answer Mode (2-Mark, 5-Mark, 10-Mark Tabs)
            item {
                SectionCard(
                    title = "8. Exam Answer Mode (Format for Marks)",
                    icon = Icons.Default.FactCheck
                ) {
                    TabRow(selectedTabIndex = selectedExamAnswerTab) {
                        Tab(
                            selected = selectedExamAnswerTab == 0,
                            onClick = { selectedExamAnswerTab = 0 },
                            text = { Text("2-Mark Answer") }
                        )
                        Tab(
                            selected = selectedExamAnswerTab == 1,
                            onClick = { selectedExamAnswerTab = 1 },
                            text = { Text("5-Mark Answer") }
                        )
                        Tab(
                            selected = selectedExamAnswerTab == 2,
                            onClick = { selectedExamAnswerTab = 2 },
                            text = { Text("10-Mark Answer") }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    val currentAnswer = when (selectedExamAnswerTab) {
                        0 -> question.twoMarkAnswer
                        1 -> question.fiveMarkAnswer
                        else -> question.tenMarkAnswer
                    }

                    Surface(
                        color = MaterialTheme.colorScheme.surface,
                        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = currentAnswer,
                            fontSize = 13.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }

            // 9 & 10. Common Mistakes & Final Summary
            item {
                SectionCard(
                    title = "9 & 10. Pitfalls & Final Summary",
                    icon = Icons.Default.WarningAmber
                ) {
                    Text(
                        text = "Common Mistakes to Avoid in Exam:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.error
                    )
                    question.commonMistakes.forEach { mistake ->
                        Text(
                            text = "⚠ $mistake",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Surface(
                        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "Final Answer Summary:",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                            Text(
                                text = question.finalAnswer,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }
            }

            // 11 & 12. Shortcut Tip & Practice Question
            item {
                SectionCard(
                    title = "11 & 12. Shortcut & Similar Practice Question",
                    icon = Icons.Default.Speed
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            Icons.Default.Bolt,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Shortcut Tip: ${question.shortcutTip}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "Similar Practice Question (Try it yourself!):",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = question.similarPracticeQuestion,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }

    // Language Dropdown Menu
    if (showLanguageMenu) {
        AlertDialog(
            onDismissRequest = { showLanguageMenu = false },
            title = { Text("Explanation Language") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Select regional language. All formulas and symbols remain strictly invariant.")
                    SupportedLanguage.values().forEach { lang ->
                        TextButton(
                            onClick = {
                                viewModel.setLanguage(lang)
                                showLanguageMenu = false
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "${lang.displayName} (${lang.nativeName})",
                                    fontWeight = if (lang == selectedLanguage) FontWeight.Bold else FontWeight.Normal
                                )
                                if (lang == selectedLanguage) {
                                    Icon(Icons.Default.Check, contentDescription = null)
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showLanguageMenu = false }) {
                    Text("Close")
                }
            }
        )
    }

    // Ask AI Bottom Sheet
    if (showAiBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showAiBottomSheet = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "DMGT AI Doubt Solver (${selectedLanguage.displayName})",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(onClick = { showAiBottomSheet = false }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Text(
                    text = "AI answers clearly and will NOT skip any mathematical steps. Explanations translated into ${selectedLanguage.displayName} with formulas invariant.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                OutlinedTextField(
                    value = userDoubtInput,
                    onValueChange = { userDoubtInput = it },
                    label = { Text("Enter your doubt or question") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 4
                )

                Button(
                    onClick = {
                        viewModel.askAiDoubt(userDoubtInput, contextTopic = question.topic)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !aiDoubtState.isLoading && userDoubtInput.isNotBlank()
                ) {
                    if (aiDoubtState.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = MaterialTheme.colorScheme.onPrimary,
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Analyzing step by step...")
                    } else {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Solve & Explain")
                    }
                }

                if (aiDoubtState.response != null) {
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 280.dp)
                    ) {
                        LazyColumn(modifier = Modifier.padding(12.dp)) {
                            item {
                                Text(
                                    text = aiDoubtState.response ?: "",
                                    fontSize = 13.sp,
                                    lineHeight = 19.sp
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
fun SectionCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            content()
        }
    }
}
