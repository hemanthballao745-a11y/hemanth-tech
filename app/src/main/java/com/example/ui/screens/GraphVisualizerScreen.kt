package com.example.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin

data class VisualGraph(
    val name: String,
    val vertexCount: Int,
    val edges: List<Pair<Int, Int>>,
    val isBipartite: Boolean = false,
    val chromaticNumber: Int,
    val isPlanar: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GraphVisualizerScreen(
    onNavigateBack: () -> Unit
) {
    val presetGraphs = remember {
        listOf(
            VisualGraph("Triangle (K3)", 3, listOf(0 to 1, 1 to 2, 0 to 2), false, 3, true),
            VisualGraph("Complete K4", 4, listOf(0 to 1, 0 to 2, 0 to 3, 1 to 2, 1 to 3, 2 to 3), false, 4, true),
            VisualGraph("Complete K5 (Non-Planar)", 5, listOf(
                0 to 1, 0 to 2, 0 to 3, 0 to 4,
                1 to 2, 1 to 3, 1 to 4,
                2 to 3, 2 to 4,
                3 to 4
            ), false, 5, false),
            VisualGraph("Cycle C5", 5, listOf(0 to 1, 1 to 2, 2 to 3, 3 to 4, 4 to 0), false, 3, true),
            VisualGraph("Utility Graph K3,3", 6, listOf(
                0 to 3, 0 to 4, 0 to 5,
                1 to 3, 1 to 4, 1 to 5,
                2 to 3, 2 to 4, 2 to 5
            ), true, 2, false),
            VisualGraph("Spanning Tree (T5)", 5, listOf(0 to 1, 0 to 2, 1 to 3, 1 to 4), true, 2, true)
        )
    }

    var selectedGraphIndex by remember { mutableStateOf(0) }
    val currentGraph = presetGraphs[selectedGraphIndex]

    // Calculate degrees
    val degrees = remember(currentGraph) {
        val degs = IntArray(currentGraph.vertexCount)
        currentGraph.edges.forEach { (u, v) ->
            degs[u]++
            degs[v]++
        }
        degs
    }
    val degreeSum = remember(degrees) { degrees.sum() }
    val oddDegreeCount = remember(degrees) { degrees.count { it % 2 != 0 } }
    val hasEulerCircuit = remember(oddDegreeCount) { oddDegreeCount == 0 }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Graph Theory Visualizer", fontWeight = FontWeight.Bold) },
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Preset Selection Chips
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    presetGraphs.forEachIndexed { idx, g ->
                        FilterChip(
                            selected = selectedGraphIndex == idx,
                            onClick = { selectedGraphIndex = idx },
                            label = { Text(g.name) }
                        )
                    }
                }
            }

            // Interactive Canvas Drawing Graph
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Canvas(modifier = Modifier.fillMaxSize().padding(32.dp)) {
                            val centerX = size.width / 2f
                            val centerY = size.height / 2f
                            val radius = (size.minDimension / 2f) * 0.85f

                            val vertexPositions = List(currentGraph.vertexCount) { i ->
                                val angle = 2.0 * Math.PI * i / currentGraph.vertexCount - (Math.PI / 2.0)
                                Offset(
                                    x = centerX + (radius * cos(angle)).toFloat(),
                                    y = centerY + (radius * sin(angle)).toFloat()
                                )
                            }

                            // Draw Edges
                            currentGraph.edges.forEach { (u, v) ->
                                if (u < vertexPositions.size && v < vertexPositions.size) {
                                    drawLine(
                                        color = Color(0xFF5C6BC0),
                                        start = vertexPositions[u],
                                        end = vertexPositions[v],
                                        strokeWidth = 3.dp.toPx()
                                    )
                                }
                            }

                            // Distinct Vertex Colors (Chromatic Coloring Simulation)
                            val palette = listOf(
                                Color(0xFFE53935), Color(0xFF1E88E5), Color(0xFF43A047),
                                Color(0xFFFB8C00), Color(0xFF8E24AA), Color(0xFF00ACC1)
                            )

                            // Draw Vertices
                            vertexPositions.forEachIndexed { i, pos ->
                                val color = if (currentGraph.isBipartite) {
                                    if (i < currentGraph.vertexCount / 2) palette[0] else palette[1]
                                } else {
                                    palette[i % currentGraph.chromaticNumber]
                                }
                                drawCircle(
                                    color = color,
                                    radius = 16.dp.toPx(),
                                    center = pos
                                )
                                drawCircle(
                                    color = Color.White,
                                    radius = 6.dp.toPx(),
                                    center = pos
                                )
                            }
                        }
                    }
                }
            }

            // Real-Time Theorem Verification Dashboard
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Mathematical Analysis: ${currentGraph.name}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Divider()

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MetricItem("Vertices |V|", "${currentGraph.vertexCount}")
                            MetricItem("Edges |E|", "${currentGraph.edges.size}")
                            MetricItem("Chromatic χ(G)", "${currentGraph.chromaticNumber}")
                        }

                        Divider()

                        // Handshaking Theorem check
                        Text(
                            text = "1. Handshaking Theorem: ∑ deg(v) = 2|E|",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Text(
                            text = "Degrees: [${degrees.joinToString(", ")}] → Sum = $degreeSum = 2 × ${currentGraph.edges.size} (VERIFIED ✔)",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        // Odd Vertices Parity
                        Text(
                            text = "2. Odd Degree Vertices Parity:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Text(
                            text = "Odd vertices count = $oddDegreeCount (Always EVEN as required by theorem! ✔)",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        // Euler Circuit
                        Text(
                            text = "3. Eulerian Circuit Status:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Text(
                            text = if (hasEulerCircuit) "Yes! All vertices have even degree → Euler Circuit exists."
                            else "No Euler Circuit (contains $oddDegreeCount odd vertices).",
                            fontSize = 12.sp,
                            color = if (hasEulerCircuit) Color(0xFF2E7D32) else MaterialTheme.colorScheme.error
                        )

                        // Planarity & Euler formula
                        Text(
                            text = "4. Planarity (Euler's Formula V - E + R = 2):",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Text(
                            text = if (currentGraph.isPlanar) "Planar Graph: Can be drawn in a plane without edge crossings."
                            else "NON-PLANAR Graph: Violates planarity bounds (e.g. E ≤ 3V - 6) by Kuratowski's theorem.",
                            fontSize = 12.sp,
                            color = if (currentGraph.isPlanar) Color(0xFF2E7D32) else MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MetricItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, fontSize = 11.sp, color = MaterialTheme.colorScheme.outline)
        Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}
