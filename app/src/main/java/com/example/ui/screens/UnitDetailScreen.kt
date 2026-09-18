package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.DmgtQuestion
import com.example.data.models.DmgtTopic
import com.example.ui.viewmodel.DmgtViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitDetailScreen(
    unitNumber: Int,
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToQuestion: (String) -> Unit
) {
    val unit = remember(unitNumber) { viewModel.repository.getUnitByNumber(unitNumber) }
    val allUnitQuestions = remember(unitNumber) { viewModel.repository.getQuestionsByUnit(unitNumber) }
    val unitFormulas = remember(unitNumber) { viewModel.repository.getFormulasByUnit(unitNumber) }

    var selectedTab by remember { mutableStateOf(0) }
    var selectedMarksFilter by remember { mutableStateOf<Int?>(null) }

    val filteredQuestions = remember(selectedMarksFilter, allUnitQuestions) {
        if (selectedMarksFilter == null) {
            allUnitQuestions
        } else {
            allUnitQuestions.filter { it.marks == selectedMarksFilter }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Unit $unitNumber: ${unit?.title ?: "DMGT"}",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Unit Overview Banner
            if (unit != null) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = unit.subtitle,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = unit.description,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // Tabs
            TabRow(selectedTabIndex = selectedTab) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text("Questions (${allUnitQuestions.size})") }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text("Topics (${unit?.topics?.size ?: 0})") }
                )
                Tab(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    text = { Text("Formulas (${unitFormulas.size})") }
                )
            }

            when (selectedTab) {
                0 -> {
                    // Question Filter Chips
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = selectedMarksFilter == null,
                            onClick = { selectedMarksFilter = null },
                            label = { Text("All") }
                        )
                        FilterChip(
                            selected = selectedMarksFilter == 2,
                            onClick = { selectedMarksFilter = 2 },
                            label = { Text("2-Marks") }
                        )
                        FilterChip(
                            selected = selectedMarksFilter == 5,
                            onClick = { selectedMarksFilter = 5 },
                            label = { Text("5-Marks") }
                        )
                        FilterChip(
                            selected = selectedMarksFilter == 10,
                            onClick = { selectedMarksFilter = 10 },
                            label = { Text("10-Marks") }
                        )
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        if (filteredQuestions.isEmpty()) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(32.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "No questions match the selected filter.",
                                        color = MaterialTheme.colorScheme.outline
                                    )
                                }
                            }
                        }

                        items(filteredQuestions) { question ->
                            QuestionListItemCard(
                                question = question,
                                onClick = { onNavigateToQuestion(question.id) }
                            )
                        }
                    }
                }
                1 -> {
                    // Topics List
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(unit?.topics ?: emptyList()) { topic ->
                            TopicCard(topic = topic)
                        }
                    }
                }
                2 -> {
                    // Unit Formulas
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(unitFormulas) { formula ->
                            FormulaCardItem(formula = formula)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuestionListItemCard(
    question: DmgtQuestion,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("question_item_${question.id}"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
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
                // Source Reference Tag
                Text(
                    text = question.sourceRef,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                AssistChip(
                    onClick = {},
                    label = { Text("${question.marks} Marks", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (question.marks == 10) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.secondaryContainer
                    ),
                    modifier = Modifier.height(26.dp)
                )
            }

            Text(
                text = question.questionText,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Formula: ${question.formula}",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Topic: ${question.topic}",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "View Solution →",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun TopicCard(topic: DmgtTopic) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = topic.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = topic.summary,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Key Concepts:",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
            topic.keyConcepts.forEach { concept ->
                Text(
                    text = "• $concept",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            if (topic.coreFormulas.isNotEmpty()) {
                Surface(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "Core Formulas:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        topic.coreFormulas.forEach { f ->
                            Text(text = f, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }
    }
}
