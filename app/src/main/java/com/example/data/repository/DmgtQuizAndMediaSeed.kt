package com.example.data.repository

import com.example.data.models.*

object DmgtQuizAndMediaSeed {

    val quizQuestions: List<DmgtQuizQuestion> = listOf(
        // Unit 1
        DmgtQuizQuestion(
            id = "qz_1",
            unitNumber = 1,
            topic = "Mathematical Logic",
            question = "Which of the following is logically equivalent to P → Q?",
            options = listOf("¬P ∨ Q", "P ∧ ¬Q", "¬P ∧ Q", "P ∨ ¬Q"),
            correctOptionIndex = 0,
            explanation = "By material implication law, P → Q is logically equivalent to ¬P ∨ Q (False only when P is True and Q is False).",
            isTwoMark = true
        ),
        DmgtQuizQuestion(
            id = "qz_2",
            unitNumber = 1,
            topic = "Mathematical Logic",
            question = "A proposition that is always True for all truth value assignments is called a:",
            options = listOf("Contingency", "Tautology", "Contradiction", "Predicate"),
            correctOptionIndex = 1,
            explanation = "A tautology is a compound proposition whose truth value is always T in every row of its truth table.",
            isTwoMark = true
        ),
        DmgtQuizQuestion(
            id = "qz_3",
            unitNumber = 1,
            topic = "Predicate Calculus",
            question = "What is the negation of the quantified statement (∀x) P(x)?",
            options = listOf("(∀x) ¬P(x)", "(∃x) ¬P(x)", "¬(∃x) P(x)", "(∃x) P(x)"),
            correctOptionIndex = 1,
            explanation = "According to De Morgan's laws for quantifiers, ¬(∀x P(x)) ≡ (∃x) ¬P(x).",
            isFormulaQuestion = true
        ),
        // Unit 2
        DmgtQuizQuestion(
            id = "qz_4",
            unitNumber = 2,
            topic = "Set Theory",
            question = "For sets A and B with |A| = 15, |B| = 20, and |A ∩ B| = 5, what is |A ∪ B|?",
            options = listOf("35", "30", "25", "40"),
            correctOptionIndex = 1,
            explanation = "By Principle of Inclusion-Exclusion: |A ∪ B| = |A| + |B| - |A ∩ B| = 15 + 20 - 5 = 30.",
            isFormulaQuestion = true
        ),
        DmgtQuizQuestion(
            id = "qz_5",
            unitNumber = 2,
            topic = "Relations",
            question = "A relation that is Reflexive, Anti-symmetric, and Transitive is known as:",
            options = listOf("Equivalence Relation", "Partial Order Relation", "Compatible Relation", "Strict Order"),
            correctOptionIndex = 1,
            explanation = "A partial ordering relation (POSET) satisfies Reflexivity, Anti-symmetry, and Transitivity.",
            isTwoMark = true
        ),
        // Unit 3
        DmgtQuizQuestion(
            id = "qz_6",
            unitNumber = 3,
            topic = "Combinatorics",
            question = "What is the number of circular permutations of 6 distinct persons seated around a round table?",
            options = listOf("720 (6!)", "120 (5!)", "60", "360"),
            correctOptionIndex = 1,
            explanation = "The circular permutations of n distinct objects is (n - 1)!. For n = 6, (6 - 1)! = 5! = 120.",
            isFormulaQuestion = true
        ),
        DmgtQuizQuestion(
            id = "qz_7",
            unitNumber = 3,
            topic = "Recurrence Relations",
            question = "If the characteristic roots of a homogeneous recurrence relation are r = 3, 3 (repeated), what is the form of the general solution?",
            options = listOf("c1 · 3^n + c2 · 3^n", "(c1 + c2 · n) · 3^n", "c1 · 3^n + c2 · n^3", "(c1 + c2) · 3^n"),
            correctOptionIndex = 1,
            explanation = "For a repeated characteristic root r with multiplicity 2, the general solution is a_n = (c1 + c2·n) r^n.",
            isFormulaQuestion = true
        ),
        // Unit 4
        DmgtQuizQuestion(
            id = "qz_8",
            unitNumber = 4,
            topic = "Graph Theory",
            question = "A connected undirected graph has an Eulerian Circuit if and only if:",
            options = listOf("Every vertex has odd degree", "Every vertex has even degree", "It has at most 2 odd vertices", "It is bipartite"),
            correctOptionIndex = 1,
            explanation = "Euler's Theorem states that a connected graph contains an Eulerian Circuit iff every vertex has an EVEN degree.",
            isTwoMark = true
        ),
        DmgtQuizQuestion(
            id = "qz_9",
            unitNumber = 4,
            topic = "Graph Theory",
            question = "If an undirected graph has 10 vertices each of degree 4, how many edges does it contain?",
            options = listOf("40", "20", "10", "16"),
            correctOptionIndex = 1,
            explanation = "By Handshaking theorem: ∑ deg(v) = 2|E|. Sum = 10 × 4 = 40 ⇒ 2|E| = 40 ⇒ |E| = 20.",
            isFormulaQuestion = true
        ),
        // Unit 5
        DmgtQuizQuestion(
            id = "qz_10",
            unitNumber = 5,
            topic = "Planar Graphs",
            question = "According to Euler's formula for connected planar graphs, V - E + R equals:",
            options = listOf("0", "1", "2", "3"),
            correctOptionIndex = 2,
            explanation = "Euler's planar formula is V - E + R = 2 (where V = vertices, E = edges, R = regions/faces).",
            isFormulaQuestion = true
        ),
        DmgtQuizQuestion(
            id = "qz_11",
            unitNumber = 5,
            topic = "Graph Coloring",
            question = "What is the chromatic number χ(G) of any complete graph K_n with n ≥ 1 vertices?",
            options = listOf("2", "n - 1", "n", "n / 2"),
            correctOptionIndex = 2,
            explanation = "In K_n, every vertex is adjacent to all other vertices. Hence no two vertices can share a color, requiring exactly n colors.",
            isTwoMark = true
        ),
        DmgtQuizQuestion(
            id = "qz_12",
            unitNumber = 5,
            topic = "Trees",
            question = "How many edges does a spanning tree of a connected graph with 25 vertices possess?",
            options = listOf("25", "24", "26", "50"),
            correctOptionIndex = 1,
            explanation = "A tree on n vertices has exactly n - 1 edges. Here 25 - 1 = 24 edges.",
            isTwoMark = true
        )
    )

    val pdfDocuments: List<DmgtPdfDoc> = listOf(
        DmgtPdfDoc(
            id = "pdf_qb_r23",
            title = "DMGT R23 Question Bank (Official Document)",
            unitNumber = null,
            type = "Official Question Bank",
            description = "Complete repository of 2-mark, 5-mark, and 10-mark university exam questions for JNTU/Autonomous R23 syllabus across Units 1 to 5.",
            pageCount = 18,
            contentMarkdown = """
# DISCRETE MATHEMATICS AND GRAPH THEORY (R23)
## Comprehensive Academic Question Bank

### UNIT I: MATHEMATICAL LOGIC
- **Statements and Notations**: Define proposition, truth values, and logical connectives.
- **WFF and Truth Tables**: Construct truth tables for conditional and biconditional statements.
- **Tautology & Contradiction**: Prove tautological implications and equivalence laws.
- **Normal Forms**: Obtain PDNF and PCNF for multi-variable formulas without and with truth tables.
- **Theory of Inference**: Demonstrate valid derivations using Rules P, T, CP, and Indirect Proof.
- **Predicate Calculus**: Quantifiers, free and bound variables, US, UG, ES, EG application in arguments.

### UNIT II: SET THEORY & ALGEBRAIC STRUCTURES
- **Inclusion-Exclusion Principle**: Proof for 2 and 3 sets, applications in survey data.
- **Relations**: Reflexive, symmetric, anti-symmetric, transitive properties.
- **Equivalence Relations**: Partitioning sets into equivalence classes.
- **POSET & Hasse Diagrams**: Finding maximal, minimal, greatest, least, LUB, and GLB.
- **Functions & Inverses**: Injective, surjective, bijective, recursive function definitions.
- **Lattices**: Modular, distributive, complemented lattices and Boolean algebra.

### UNIT III: COMBINATORICS AND RECURRENCE RELATIONS
- **Counting Rules**: Sum rule, product rule, pigeonhole principle.
- **Permutations and Combinations**: Word arrangements, circular seating, restricted combinations.
- **Generating Functions**: Closed form expansions, coefficient extraction using partial fractions.
- **Recurrence Relations**: Linear homogeneous recurrence with characteristic roots; inhomogeneous particular solutions.

### UNIT IV: GRAPH THEORY
- **Fundamentals**: Vertices, edges, handshaking theorem, in-degree, out-degree.
- **Representations**: Adjacency matrix, incidence matrix, graph complement.
- **Isomorphism**: Checking vertex invariants, degree sequences, and adjacency preservation.
- **Eulerian & Hamiltonian Graphs**: Euler circuits, Dirac's and Ore's theorems.

### UNIT V: MULTI GRAPHS & TREES
- **Planar Graphs**: Euler's formula V - E + R = 2, bounds E ≤ 3V - 6, Kuratowski's theorem.
- **Graph Coloring**: Vertex coloring, chromatic number χ(G), Four Color Theorem.
- **Trees & Spanning Trees**: Tree properties (|E| = |V| - 1), Cayley's formula.
- **Minimum Spanning Trees**: Prim's and Kruskal's algorithms step-by-step traces.
- **Traversals**: BFS and DFS spanning trees.
            """.trimIndent()
        ),
        DmgtPdfDoc(
            id = "pdf_formulas",
            title = "DMGT Complete Formula Sheet (All Units)",
            unitNumber = null,
            type = "Formula Sheet",
            description = "Exhaustive compilation of all mathematical logic laws, set theory equations, counting formulas, and graph theory theorems.",
            pageCount = 8,
            contentMarkdown = """
# DMGT R23 MASTER FORMULA BANK

### 1. LOGIC & EQUIVALENCE LAWS
- Conditional: P → Q ≡ ¬P ∨ Q
- Biconditional: P ↔ Q ≡ (P → Q) ∧ (Q → P)
- De Morgan: ¬(P ∧ Q) ≡ ¬P ∨ ¬Q, ¬(P ∨ Q) ≡ ¬P ∧ ¬Q
- Absorption: P ∨ (P ∧ Q) ≡ P, P ∧ (P ∨ Q) ≡ P
- Modus Ponens: P, P → Q ⇒ Q
- Modus Tollens: ¬Q, P → Q ⇒ ¬P
- Quantifier Negation: ¬(∀x P(x)) ≡ ∃x ¬P(x)

### 2. SET THEORY & RELATIONS
- Inclusion-Exclusion (2 Sets): |A ∪ B| = |A| + |B| - |A ∩ B|
- Inclusion-Exclusion (3 Sets): |A ∪ B ∪ C| = |A| + |B| + |C| - (|A ∩ B| + |B ∩ C| + |C ∩ A|) + |A ∩ B ∩ C|
- POSET: Reflexive + Anti-symmetric + Transitive
- Divisibility POSET: GLB(a, b) = gcd(a, b), LUB(a, b) = lcm(a, b)

### 3. COMBINATORICS
- Permutation: P(n, r) = n! / (n - r)!
- Permutations with Repetition: n! / (n1! n2! ... nk!)
- Circular Permutation: (n - 1)!
- Combinations: C(n, r) = n! / (r! (n - r)!)
- Pascal's Identity: C(n, r) = C(n - 1, r) + C(n - 1, r - 1)
- Generating function: G(x) = ∑ a_n x^n, 1/(1 - ax) = ∑ a^n x^n
- Distinct Roots Recurrence: a_n = c1 (r1)^n + c2 (r2)^n

### 4. GRAPH THEORY
- Handshaking Theorem: ∑ deg(v) = 2|E|
- Complement Edges: |E(G-bar)| = n(n - 1)/2 - |E(G)|
- Euler Circuit Condition: Connected graph with all even degree vertices
- Dirac's Theorem (Hamiltonian): deg(v) ≥ n/2 for all v with n ≥ 3

### 5. MULTI GRAPHS & TREES
- Euler's Planar Formula: V - E + R = 2
- Planarity Bound: E ≤ 3V - 6 (for V ≥ 3 simple planar)
- Bipartite Planar Bound: E ≤ 2V - 4
- Tree Edge Count: |E| = |V| - 1
- Cayley's Spanning Trees on Kn: n^(n - 2)
- Chromatic Numbers: χ(Kn) = n, χ(Km,n) = 2, χ(C_even) = 2, χ(C_odd) = 3
            """.trimIndent()
        ),
        DmgtPdfDoc(
            id = "pdf_imp_q",
            title = "DMGT Most Important Exam Questions",
            unitNumber = null,
            type = "Important Questions",
            description = "Curated high-frequency exam questions categorized into 2-mark definitions, 5-mark derivations, and 10-mark algorithms.",
            pageCount = 12,
            contentMarkdown = """
# DMGT R23 HIGH-FREQUENCY EXAM QUESTIONS

### 2-MARK CRITICAL QUESTIONS:
1. Define Tautology, Contradiction, and Contingency with examples.
2. State the Duality Law in propositional logic.
3. Write the negation of (∀x)(∃y)(P(x,y) → Q(x,y)).
4. Define POSET and Hasse diagram.
5. What is the Handshaking Theorem? State its main corollary.
6. Differentiate between an Euler Circuit and a Hamiltonian Cycle.
7. State Euler's formula for planar graphs.
8. What is the chromatic number of K5 and K3,3?

### 5-MARK CONCEPTUAL & NUMERICAL QUESTIONS:
1. State and prove the Principle of Inclusion-Exclusion for two sets with an example.
2. Prove that the relation 'a ≡ b (mod 5)' is an equivalence relation on integers and find the equivalence classes.
3. Find the number of permutations of the word 'ENGINEERING' starting with E and ending with G.
4. Construct the Adjacency and Incidence matrices for a complete graph K4.
5. Explain Graph Coloring and find the chromatic number of cycle graph Cn for both even and odd n.

### 10-MARK EXHAUSTIVE QUESTIONS:
1. Obtain the Principal Disjunctive Normal Form (PDNF) and Principal Conjunctive Normal Form (PCNF) of (P ∧ Q) ∨ (¬P ∧ R) ∨ (Q ∧ R).
2. For D_24 = {1, 2, 3, 4, 6, 8, 12, 24} ordered by divisibility, draw the Hasse diagram and identify maximal, minimal, greatest, least elements, and GLB/LUB of {4, 6}.
3. Solve the recurrence relation a_n - 7a_{n-1} + 10a_{n-2} = 0 with a_0 = 1, a_1 = 8.
4. State Euler's formula for connected planar graphs. Prove E ≤ 3V - 6 and show that K5 is non-planar.
5. Detail Kruskal's and Prim's MST algorithms and trace Kruskal's algorithm on a weighted 5-vertex graph.
            """.trimIndent()
        )
    )

    val videoLessons: List<VideoLesson> = listOf(
        VideoLesson(
            id = "vid_01",
            unitNumber = 1,
            title = "Mastering Truth Tables & Tautologies",
            durationSec = 180,
            slides = listOf(
                VideoSlide(
                    slideNumber = 1,
                    title = "What is a Proposition & Tautology?",
                    formula = "P ∨ ¬P ≡ T",
                    bulletPoints = listOf(
                        "Proposition: A statement that is either True or False.",
                        "Tautology: A statement formula that is TRUE for all truth assignments.",
                        "Contradiction: A statement formula that is FALSE for all truth assignments."
                    ),
                    narrationEn = "Welcome to DMGT Lesson 1. In mathematical logic, a proposition is a declarative sentence that is either True or False. A tautology is a compound statement that always evaluates to True, such as P or not P.",
                    narrationTe = "DMGT లెసన్ 1 కి స్వాగతం. గణిత లాజిక్‌లో, ఒక ప్రతిపాదన ఎల్లప్పుడూ నిజం లేదా అబద్ధం అవుతుంది. అన్ని సందర్భాలలో నిజం అయ్యే ఫార్ములాను టాటాలజీ అంటారు.",
                    narrationHi = "DMGT पाठ 1 में आपका स्वागत है। गणितीय तर्क में, एक कथन जो सभी स्थितियों में सत्य होता है, उसे टॉटोलॉजी कहा जाता है।"
                ),
                VideoSlide(
                    slideNumber = 2,
                    title = "Truth Table Construction",
                    formula = "Rows = 2^n for n variables",
                    bulletPoints = listOf(
                        "For 2 variables (P, Q): 2^2 = 4 rows (TT, TF, FT, FF).",
                        "For 3 variables (P, Q, R): 2^3 = 8 rows.",
                        "Check the final column: All T's indicates a Tautology!"
                    ),
                    narrationEn = "To prove a tautology, construct a truth table with 2 raised to the power n rows. If the final column contains only True values, the formula is a certified tautology.",
                    narrationTe = "టాటాలజీని నిరూపించడానికి, 2 పవర్ n వరుసలతో ట్రూత్ టేబుల్‌ను తయారు చేయండి. చివరి నిలువు వరుసలో అన్నీ T లు ఉంటే అది టాటాలజీ.",
                    narrationHi = "टॉटोलॉजी सिद्ध करने के लिए सत्य सारणी बनाएं। यदि अंतिम स्तंभ में केवल सत्य (T) मान हैं, तो वह टॉटोलॉजी है।"
                )
            )
        ),
        VideoLesson(
            id = "vid_02",
            unitNumber = 4,
            title = "Handshaking Theorem & Graph Degrees",
            durationSec = 210,
            slides = listOf(
                VideoSlide(
                    slideNumber = 1,
                    title = "The Handshaking Theorem",
                    formula = "∑ deg(v) = 2 |E|",
                    bulletPoints = listOf(
                        "Every edge connects two vertices.",
                        "Each edge contributes 1 to the degree of two endpoints.",
                        "Total degree sum is twice the number of edges, hence always even!"
                    ),
                    narrationEn = "The Handshaking Theorem states that the sum of degrees of all vertices in any graph is twice the number of edges. Because each edge has two endpoints, it adds two to the total degree count.",
                    narrationTe = "హ్యాండ్‌షేకింగ్ సిద్ధాంతం ప్రకారం, గ్రాఫ్‌లోని అన్ని శీర్షాల డిగ్రీల మొత్తం అంచుల సంఖ్యకు రెట్టింపు ఉంటుంది: సమ్ ఆఫ్ డిగ్రీస్ = 2 ఇంటూ ఎడ్జెస్.",
                    narrationHi = "हैंडशेकिंग प्रमेय के अनुसार, किसी भी ग्राफ के सभी शीर्षों की डिग्रियों का योग किनारों की संख्या का दोगुना होता है।"
                ),
                VideoSlide(
                    slideNumber = 2,
                    title = "Odd Degree Vertices are Even in Number",
                    formula = "|V_odd| is always EVEN",
                    bulletPoints = listOf(
                        "Sum of degrees is always an even integer (2E).",
                        "Sum of even vertices is even.",
                        "Sum of odd vertices must be even, meaning count of odd vertices is even!"
                    ),
                    narrationEn = "A vital consequence of this theorem is that the number of vertices with odd degree is always even. In an exam, if the sum of degrees is odd, no such graph can exist!",
                    narrationTe = "ఈ సిద్ధాంతం వల్ల బేసి డిగ్రీ కలిగిన శీర్షాల సంఖ్య ఎల్లప్పుడూ సరి సంఖ్యలోనే ఉంటుంది. పరీక్షలో డిగ్రీల మొత్తం బేసి సంఖ్య వస్తే, ఆ గ్రాఫ్ అసాధ్యం!",
                    narrationHi = "इस प्रमेय का एक महत्वपूर्ण परिणाम यह है कि विषम डिग्री वाले शीर्षों की संख्या हमेशा सम होती है।"
                )
            )
        ),
        VideoLesson(
            id = "vid_03",
            unitNumber = 5,
            title = "Minimum Spanning Tree: Kruskal's Algorithm",
            durationSec = 240,
            slides = listOf(
                VideoSlide(
                    slideNumber = 1,
                    title = "Greedy Edge Selection",
                    formula = "MST Edges = |V| - 1",
                    bulletPoints = listOf(
                        "Sort all edges in ascending order of their weights.",
                        "Repeatedly select the lowest weight edge.",
                        "Discard any edge that creates a closed cycle."
                    ),
                    narrationEn = "Kruskal's algorithm finds a Minimum Spanning Tree by sorting all edges from smallest to largest weight and greedily picking edges that do not create cycles.",
                    narrationTe = "క్రుస్కల్ అల్గారిథమ్ తక్కువ బరువు ఉన్న అంచులను వరుసగా ఎంచుకుంటూ సైకిల్స్ రాకుండా కనిష్ట స్పాన్నింగ్ ట్రీని నిర్మిస్తుంది.",
                    narrationHi = "क्रुस्कल का एल्गोरिदम सभी किनारों को भार के अनुसार छांटता है और बिना चक्र बनाए न्यूनतम फैलावदार वृक्ष बनाता है।"
                ),
                VideoSlide(
                    slideNumber = 2,
                    title = "Termination & Total Weight",
                    formula = "w(T) = ∑ w(e)",
                    bulletPoints = listOf(
                        "Stop immediately when |V| - 1 edges are accepted.",
                        "Sum the weights of the accepted edges for total MST weight."
                    ),
                    narrationEn = "For a graph with V vertices, stop as soon as you have chosen V minus 1 edges. The sum of these edge weights gives the optimal minimal spanning tree.",
                    narrationTe = "V శీర్షాలు ఉన్నప్పుడు, V మైనస్ 1 అంచులు రాగానే ఆపండి. వాటి బరువుల మొత్తం మనకు కనీస బరువును ఇస్తుంది.",
                    narrationHi = "V शीर्षों के लिए, V माइनस 1 किनारे मिलते ही रुक जाएं। उनका योग न्यूनतम वृक्ष भार होगा।"
                )
            )
        )
    )
}
