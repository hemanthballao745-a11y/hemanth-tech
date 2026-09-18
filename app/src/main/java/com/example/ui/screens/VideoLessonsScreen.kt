package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.SupportedLanguage
import com.example.data.models.VideoLesson
import com.example.ui.viewmodel.DmgtViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoLessonsScreen(
    viewModel: DmgtViewModel,
    onNavigateBack: () -> Unit
) {
    val lessons = remember { viewModel.repository.getAllVideoLessons() }
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()

    var activeLesson by remember { mutableStateOf<VideoLesson?>(null) }
    var currentSlideIndex by remember { mutableStateOf(0) }
    var isPlaying by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (activeLesson != null) activeLesson!!.title else "AI Video Explanations",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (activeLesson != null) {
                                activeLesson = null
                                isPlaying = false
                            } else {
                                onNavigateBack()
                            }
                        }
                    ) {
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
            if (activeLesson == null) {
                // Lesson List
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
                                    text = "AI Multi-lingual Video Lessons",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Interactive visual slides paired with localized AI voice narrations in English, Telugu, and Hindi.",
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    items(lessons) { lesson ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    activeLesson = lesson
                                    currentSlideIndex = 0
                                    isPlaying = true
                                },
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
                                        .size(48.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.primary),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onPrimary,
                                        modifier = Modifier.size(28.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = lesson.title,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "Unit ${lesson.unitNumber} • ${lesson.slides.size} Visual Slides • ${lesson.durationSec}s",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                                Icon(Icons.Default.ChevronRight, contentDescription = null, tint = MaterialTheme.colorScheme.outline)
                            }
                        }
                    }
                }
            } else {
                // Interactive Video Player Slide View
                val lesson = activeLesson!!
                val currentSlide = lesson.slides.getOrNull(currentSlideIndex) ?: lesson.slides[0]

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
                        // Slide Progress
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Slide ${currentSlide.slideNumber} of ${lesson.slides.size}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Language: ${selectedLanguage.displayName}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.outline
                            )
                        }

                        LinearProgressIndicator(
                            progress = { (currentSlideIndex + 1).toFloat() / lesson.slides.size },
                            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
                        )

                        // Main Slide Visual Canvas
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                        ) {
                            Column(
                                modifier = Modifier.padding(18.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Text(
                                    text = currentSlide.title,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Surface(
                                    color = MaterialTheme.colorScheme.surface,
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = currentSlide.formula,
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.padding(12.dp)
                                    )
                                }

                                currentSlide.bulletPoints.forEach { point ->
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Text("✔", color = MaterialTheme.colorScheme.primary)
                                        Text(text = point, fontSize = 13.sp, lineHeight = 18.sp)
                                    }
                                }
                            }
                        }

                        // Localized Voice Narration Transcript
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.VolumeUp,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Text(
                                        text = "AI Narration Transcript (${selectedLanguage.displayName}):",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                val narrationText = when (selectedLanguage) {
                                    SupportedLanguage.TELUGU -> currentSlide.narrationTe
                                    SupportedLanguage.HINDI -> currentSlide.narrationHi
                                    else -> currentSlide.narrationEn
                                }
                                Text(
                                    text = narrationText,
                                    fontSize = 13.sp,
                                    lineHeight = 19.sp,
                                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                                )
                            }
                        }
                    }

                    // Video Controls Row
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = {
                                    if (currentSlideIndex > 0) currentSlideIndex--
                                },
                                enabled = currentSlideIndex > 0
                            ) {
                                Icon(Icons.Default.SkipPrevious, contentDescription = "Previous Slide")
                            }

                            FilledIconButton(
                                onClick = { isPlaying = !isPlaying },
                                modifier = Modifier.size(52.dp)
                            ) {
                                Icon(
                                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = if (isPlaying) "Pause" else "Play"
                                )
                            }

                            IconButton(
                                onClick = {
                                    if (currentSlideIndex < lesson.slides.size - 1) currentSlideIndex++
                                },
                                enabled = currentSlideIndex < lesson.slides.size - 1
                            ) {
                                Icon(Icons.Default.SkipNext, contentDescription = "Next Slide")
                            }
                        }
                    }
                }
            }
        }
    }
}
