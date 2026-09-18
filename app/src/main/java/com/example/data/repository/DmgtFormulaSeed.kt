package com.example.data.repository

import com.example.data.models.DmgtFormula

object DmgtFormulaSeed {

    val formulas: List<DmgtFormula> = listOf(
        DmgtFormula(
            id = "f_01",
            unitNumber = 1,
            name = "De Morgan's Laws (Logic)",
            category = "Equivalence of Formulas",
            formula = "¬(P ∧ Q) ≡ ¬P ∨ ¬Q\n¬(P ∨ Q) ≡ ¬P ∧ ¬Q",
            symbolBreakdown = listOf(
                "¬" to "Negation (NOT)",
                "∧" to "Conjunction (AND)",
                "∨" to "Disjunction (OR)",
                "≡" to "Logically Equivalent"
            ),
            whenToUse = "Use when pushing negations inside parentheses or converting between conjunctions and disjunctions in normal forms.",
            example = "Negate 'It is sunny and hot': 'It is not sunny OR it is not hot'.",
            stepByStep = listOf(
                "Step 1: Identify compound statement with outer negation.",
                "Step 2: Negate each internal proposition.",
                "Step 3: Flip the connective (∧ becomes ∨, and ∨ becomes ∧)."
            ),
            commonMistake = "Negating propositions but forgetting to flip ∧ to ∨ or vice-versa."
        ),
        DmgtFormula(
            id = "f_02",
            unitNumber = 1,
            name = "Conditional Equivalences",
            category = "Propositional Equivalences",
            formula = "P → Q ≡ ¬P ∨ Q\nP ↔ Q ≡ (P → Q) ∧ (Q → P)",
            symbolBreakdown = listOf(
                "→" to "Material Implication (If P then Q)",
                "↔" to "Biconditional (P if and only if Q)",
                "¬P" to "Negation of premise P",
                "∨" to "Disjunction"
            ),
            whenToUse = "Crucial for simplifying implications into CNF/DNF and eliminating arrows in inference proofs.",
            example = "If it rains, ground is wet ≡ Either it does not rain, or ground is wet.",
            stepByStep = listOf(
                "Step 1: Replace P → Q with (¬P ∨ Q).",
                "Step 2: Apply De Morgan's or distributive laws as needed."
            ),
            commonMistake = "Writing P → Q ≡ P ∨ ¬Q instead of ¬P ∨ Q."
        ),
        DmgtFormula(
            id = "f_03",
            unitNumber = 2,
            name = "Principle of Inclusion-Exclusion (2 & 3 Sets)",
            category = "Set Theory Cardinality",
            formula = "|A ∪ B| = |A| + |B| - |A ∩ B|\n|A ∪ B ∪ C| = |A| + |B| + |C| - (|A ∩ B| + |B ∩ C| + |C ∩ A|) + |A ∩ B ∩ C|",
            symbolBreakdown = listOf(
                "|S|" to "Cardinality (size) of set S",
                "∪" to "Union of sets",
                "∩" to "Intersection of sets"
            ),
            whenToUse = "When finding number of elements in union of non-disjoint sets or counting elements with multiple properties.",
            example = "In a class: |A|=50, |B|=40, |A ∩ B|=15 ⇒ |A ∪ B| = 50 + 40 - 15 = 75.",
            stepByStep = listOf(
                "Step 1: Add individual set sizes.",
                "Step 2: Subtract sizes of all pairs to remove double counting.",
                "Step 3: Add back size of triple intersection (for 3 sets) to restore triple overlap."
            ),
            commonMistake = "Subtracting the triple intersection instead of adding it in 3-set problems."
        ),
        DmgtFormula(
            id = "f_04",
            unitNumber = 3,
            name = "Combinations Formula (nCr)",
            category = "Combinatorics",
            formula = "nCr = n! / (r! · (n - r)!)",
            symbolBreakdown = listOf(
                "n" to "Total number of items in the set",
                "r" to "Number of items chosen/selected without regard to order",
                "!" to "Factorial function: n! = n × (n-1) × ... × 1",
                "nCr" to "Number of unordered combinations of n things taken r at a time"
            ),
            whenToUse = "Use when order of selection does NOT matter (e.g., forming a committee, selecting cards, choosing vertices).",
            example = "Choose 3 students from 7: 7C3 = 7! / (3! · 4!) = (7 × 6 × 5) / (3 × 2 × 1) = 35.",
            stepByStep = listOf(
                "Step 1: Calculate numerator: n × (n-1) × ... for r factors.",
                "Step 2: Calculate denominator: r × (r-1) × ... × 1.",
                "Step 3: Divide numerator by denominator."
            ),
            commonMistake = "Using nPr instead of nCr when the order of items does not matter."
        ),
        DmgtFormula(
            id = "f_05",
            unitNumber = 3,
            name = "Linear Recurrence (Distinct Characteristic Roots)",
            category = "Recurrence Relations",
            formula = "a_n = c_1 (r_1)^n + c_2 (r_2)^n",
            symbolBreakdown = listOf(
                "a_n" to "n-th term of the sequence",
                "r_1, r_2" to "Roots of characteristic equation r^2 - Ar - B = 0",
                "c_1, c_2" to "Constants determined by initial conditions a_0, a_1",
                "n" to "Index n ≥ 0"
            ),
            whenToUse = "Solving second-order linear homogeneous recurrence relations where characteristic polynomial has distinct real roots.",
            example = "If roots are 2 and 3, general solution is a_n = c_1 2^n + c_2 3^n.",
            stepByStep = listOf(
                "Step 1: Write characteristic equation r^2 - Ar - B = 0.",
                "Step 2: Factorize to find roots r_1, r_2.",
                "Step 3: Form general solution a_n = c_1(r_1)^n + c_2(r_2)^n.",
                "Step 4: Plug in n = 0 and n = 1 to solve for constants c_1, c_2."
            ),
            commonMistake = "Using this formula when roots are repeated (for repeated root r, formula is (c_1 + c_2 n) r^n)."
        ),
        DmgtFormula(
            id = "f_06",
            unitNumber = 4,
            name = "Handshaking Theorem",
            category = "Graph Fundamentals",
            formula = "∑_{v ∈ V} deg(v) = 2 |E|",
            symbolBreakdown = listOf(
                "V" to "Vertex set of graph G",
                "E" to "Edge set of graph G",
                "deg(v)" to "Degree of vertex v",
                "|E|" to "Total number of edges"
            ),
            whenToUse = "Finding total edges given vertex degrees, or verifying whether a degree sequence can form a valid graph.",
            example = "A graph with 4 vertices of degree 3 has 4 × 3 = 12 = 2|E| ⇒ |E| = 6.",
            stepByStep = listOf(
                "Step 1: Sum the degrees of all vertices in the graph.",
                "Step 2: Check if sum is even (if odd, such a graph cannot exist).",
                "Step 3: Divide sum by 2 to obtain number of edges |E|."
            ),
            commonMistake = "Forgetting to divide the degree sum by 2 when asked for the number of edges."
        ),
        DmgtFormula(
            id = "f_07",
            unitNumber = 5,
            name = "Euler's Formula for Planar Graphs",
            category = "Planar Graphs",
            formula = "V - E + R = 2\n(E ≤ 3V - 6 for simple planar graphs)",
            symbolBreakdown = listOf(
                "V" to "Number of vertices",
                "E" to "Number of edges",
                "R" to "Number of regions (faces) including the outer unbounded face"
            ),
            whenToUse = "Calculating regions in a planar embedding or proving a graph is non-planar (like K5 or K3,3).",
            example = "Planar graph with V = 6, E = 9: R = 2 - 6 + 9 = 5 regions.",
            stepByStep = listOf(
                "Step 1: Identify number of vertices V and edges E.",
                "Step 2: Use R = 2 - V + E.",
                "Step 3: Remember that R includes 1 external infinite region."
            ),
            commonMistake = "Forgetting to count the exterior unbounded face in the region count R."
        ),
        DmgtFormula(
            id = "f_08",
            unitNumber = 5,
            name = "Tree Edge Property & Cayley's Formula",
            category = "Trees & Spanning Trees",
            formula = "|E| = |V| - 1\nSpanning trees of K_n = n^(n-2)",
            symbolBreakdown = listOf(
                "|V|" to "Number of vertices in tree T",
                "|E|" to "Number of edges in tree T",
                "K_n" to "Complete graph on n vertices",
                "n^(n-2)" to "Cayley's theorem for distinct labeled spanning trees"
            ),
            whenToUse = "Verifying tree properties, checking spanning tree edge count, or calculating total spanning trees of Kn.",
            example = "A tree with 10 vertices has 10 - 1 = 9 edges. K4 has 4^(4-2) = 4^2 = 16 spanning trees.",
            stepByStep = listOf(
                "Step 1: For any tree, count edges as vertices minus 1.",
                "Step 2: For K_n, substitute n into n^(n-2)."
            ),
            commonMistake = "Thinking a tree can have cycles. Trees are strictly acyclic connected graphs."
        )
    )
}
