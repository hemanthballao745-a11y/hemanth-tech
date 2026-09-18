package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.DmgtUnit
import com.example.data.models.SupportedLanguage
import com.example.ui.viewmodel.DmgtViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: DmgtViewModel,
    onNavigateToUnit: (Int) -> Unit,
    onNavigateToImportantQuestions: () -> Unit,
    onNavigateToTwoMark: () -> Unit,
    onNavigateToLongQuestions: () -> Unit,
    onNavigateToFormulas: () -> Unit,
    onNavigateToQuiz: () -> Unit,
    onNavigateToPractice: () -> Unit,
    onNavigateToVideos: () -> Unit,
    onNavigateToPdf: (String) -> Unit,
    onNavigateToBookmarks: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToGraphVisualizer: () -> Unit,
    onNavigateToAdmin: () -> Unit
) {
    val authState by viewModel.authState.collectAsState()
    val userProgress by viewModel.userProgress.collectAsState()
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()
    val units = remember { viewModel.repository.getUnits() }

    var showLanguageSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "DMGT AI Study Assistant",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "R23 Question Bank • ${selectedLanguage.displayName}",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                actions = {
                    // Language Switcher
                    IconButton(
                        onClick = { showLanguageSheet = true },
                        modifier = Modifier.testTag("home_language_button")
                    ) {
                        Icon(Icons.Default.Translate, contentDescription = "Change Language")
                    }

                    // Search Button
                    IconButton(
                        onClick = onNavigateToSearch,
                        modifier = Modifier.testTag("home_search_button")
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Search Question Bank")
                    }

                    // Bookmarks
                    IconButton(
                        onClick = onNavigateToBookmarks,
                        modifier = Modifier.testTag("home_bookmarks_button")
                    ) {
                        Icon(Icons.Default.Bookmark, contentDescription = "Saved Bookmarks")
                    }

                    // Profile
                    IconButton(
                        onClick = onNavigateToProfile,
                        modifier = Modifier.testTag("home_profile_button")
                    ) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "User Profile")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Student Welcome & Streak Banner
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Welcome, ${authState.userName}!",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Learn DMGT Clearly. Step by Step.",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                SuggestionChip(
                                    onClick = onNavigateToProfile,
                                    label = { Text("Streak: ${userProgress?.currentStreak ?: 1} Days 🔥") },
                                    colors = SuggestionChipDefaults.suggestionChipColors(
                                        containerColor = MaterialTheme.colorScheme.surface
                                    )
                                )
                                SuggestionChip(
                                    onClick = onNavigateToBookmarks,
                                    label = { Text("${userProgress?.questionsReadCount ?: 0} Read 📖") },
                                    colors = SuggestionChipDefaults.suggestionChipColors(
                                        containerColor = MaterialTheme.colorScheme.surface
                                    )
                                )
                            }
                        }
                    }
                }
            }

            // Quick Action Grid (User Request 2: Important Q, 2-Mark, 5/10-Mark, Formulas, AI Video, PDFs, Practice, Quiz)
            item {
                Text(
                    text = "Study Essentials & Tools",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    QuickActionCard(
                        title = "Important Qs",
                        subtitle = "Exam High Frequency",
                        icon = Icons.Default.Star,
                        onClick = onNavigateToImportantQuestions
                    )
                    QuickActionCard(
                        title = "2-Mark Qs",
                        subtitle = "Short Definitions",
                        icon = Icons.Default.ShortText,
                        onClick = onNavigateToTwoMark
                    )
                    QuickActionCard(
                        title = "5 & 10 Marks",
                        subtitle = "Detailed Derivations",
                        icon = Icons.Default.Article,
                        onClick = onNavigateToLongQuestions
                    )
                    QuickActionCard(
                        title = "Formula Bank",
                        subtitle = "Laws & Theorems",
                        icon = Icons.Default.Functions,
                        onClick = onNavigateToFormulas
                    )
                    QuickActionCard(
                        title = "AI Video Lessons",
                        subtitle = "Narrated Slides",
                        icon = Icons.Default.SmartDisplay,
                        onClick = onNavigateToVideos
                    )
                    QuickActionCard(
                        title = "R23 PDFs",
                        subtitle = "Question Bank & Notes",
                        icon = Icons.Default.PictureAsPdf,
                        onClick = { onNavigateToPdf("pdf_qb_r23") }
                    )
                    QuickActionCard(
                        title = "Exam Practice",
                        subtitle = "2 / 5 / 10 Mark Mode",
                        icon = Icons.Default.AssignmentTurnedIn,
                        onClick = onNavigateToPractice
                    )
                    QuickActionCard(
                        title = "Interactive Quiz",
                        subtitle = "Test Your Knowledge",
                        icon = Icons.Default.Quiz,
                        onClick = onNavigateToQuiz
                    )
                    QuickActionCard(
                        title = "Graph Tool",
                        subtitle = "Degrees & Planarity",
                        icon = Icons.Default.Hub,
                        onClick = onNavigateToGraphVisualizer
                    )
                }
            }

            // Section Header: DMGT Units 1–5
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "DMGT Units 1–5 (R23 Syllabus)",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "5 Units",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            // Unit Cards
            items(units) { unit ->
                UnitCard(
                    unit = unit,
                    onClick = { onNavigateToUnit(unit.unitNumber) }
                )
            }

            // Admin Link if Admin user
            if (authState.isAdmin) {
                item {
                    OutlinedButton(
                        onClick = onNavigateToAdmin,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.AdminPanelSettings, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Open Faculty / Admin Panel")
                    }
                }
            }
        }
    }

    // Language Selector Sheet
    if (showLanguageSheet) {
        ModalBottomSheet(
            onDismissRequest = { showLanguageSheet = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Select Study Explanation Language",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Mathematical formulas and symbols remain invariant while explanations are translated into your selected regional language.",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Divider()

                SupportedLanguage.values().forEach { lang ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                viewModel.setLanguage(lang)
                                showLanguageSheet = false
                            }
                            .padding(vertical = 10.dp, horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "${lang.displayName} (${lang.nativeName})",
                                fontWeight = if (lang == selectedLanguage) FontWeight.Bold else FontWeight.Normal,
                                color = if (lang == selectedLanguage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                            )
                        }
                        if (lang == selectedLanguage) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Selected",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuickActionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(136.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun UnitCard(
    unit: DmgtUnit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable(onClick = onClick)
            .testTag("unit_card_${unit.unitNumber}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "U${unit.unitNumber}",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "UNIT ${unit.unitNumber}: ${unit.title}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = unit.subtitle,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = unit.description,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "${unit.topics.size} Topics",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Text(
                        text = "•",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Text(
                        text = "${unit.questionCount} R23 Questions",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Open Unit",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
