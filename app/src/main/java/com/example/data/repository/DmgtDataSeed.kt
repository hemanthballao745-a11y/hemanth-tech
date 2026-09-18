package com.example.data.repository

import com.example.data.models.*

object DmgtDataSeed {

    val units = listOf(
        DmgtUnit(
            unitNumber = 1,
            title = "Mathematical Logic",
            subtitle = "Propositional Logic & Predicate Calculus",
            description = "Truth tables, connectives, tautologies, normal forms (PDNF/PCNF), rules of inference, and predicate logic with quantifiers.",
            topics = listOf(
                DmgtTopic("u1_t1", 1, "Statements and Notations", "Declarative sentences that are either true or false.", listOf("Proposition", "Truth value", "Atomic statement"), listOf("P, Q, R...")),
                DmgtTopic("u1_t2", 1, "Logical Connectives", "Negation, Conjunction, Disjunction, Implication, Biconditional.", listOf("NOT (~, ¬)", "AND (∧)", "OR (∨)", "CONDITIONAL (→)", "BICONDITIONAL (↔)"), listOf("P → Q ≡ ¬P ∨ Q")),
                DmgtTopic("u1_t3", 1, "Well Formed Formulas & Truth Tables", "Syntactically correct formulas and evaluation tables.", listOf("WFF rules", "2^n rows in truth table"), listOf("rows = 2^n")),
                DmgtTopic("u1_t4", 1, "Tautologies & Equivalence of Formulas", "Statements always true; logical equivalence laws.", listOf("Tautology", "Contradiction", "De Morgan's Laws", "Duality Law"), listOf("¬(P ∧ Q) ≡ ¬P ∨ ¬Q")),
                DmgtTopic("u1_t5", 1, "Normal Forms (PDNF & PCNF)", "Disjunctive and Conjunctive Normal Forms using minterms and maxterms.", listOf("Minterms", "Maxterms", "PDNF", "PCNF"), listOf("PDNF = ∑m, PCNF = ∏M")),
                DmgtTopic("u1_t6", 1, "Theory of Inference & Indirect Proof", "Deriving conclusions using Rules P, T, CP, and Proof by Contradiction.", listOf("Modus Ponens", "Modus Tollens", "Hypothetical Syllogism", "Indirect Proof"), listOf("P, P → Q ⇒ Q")),
                DmgtTopic("u1_t7", 1, "Predicate Calculus & Quantifiers", "Predicates, universal (∀) and existential (∃) quantifiers, free/bound variables, inference rules US, UG, ES, EG.", listOf("Universe of Discourse", "Free & Bound Variables", "Quantifier Negation"), listOf("¬(∀x P(x)) ≡ ∃x ¬P(x)"))
            ),
            questionCount = 12,
            formulaCount = 8
        ),
        DmgtUnit(
            unitNumber = 2,
            title = "Set Theory",
            subtitle = "Sets, Relations, Functions & Lattices",
            description = "Inclusion-Exclusion principle, relation properties, partitions, Hasse diagrams, POSETs, bijective functions, recursive functions, and lattices.",
            topics = listOf(
                DmgtTopic("u2_t1", 2, "Sets & Inclusion-Exclusion Principle", "Operations on sets and calculating union cardinality.", listOf("Union", "Intersection", "Difference", "PIE"), listOf("|A ∪ B| = |A| + |B| - |A ∩ B|")),
                DmgtTopic("u2_t2", 2, "Relations & Properties", "Reflexive, Symmetric, Anti-symmetric, Transitive relations.", listOf("Reflexivity", "Symmetry", "Anti-symmetry", "Transitivity"), listOf("a R a, a R b ⇒ b R a")),
                DmgtTopic("u2_t3", 2, "Equivalence Relations & Partitions", "Relations that partition sets into disjoint equivalence classes.", listOf("Equivalence Class [a]", "Fundamental Theorem of Equivalence"), listOf("[a] ∩ [b] = ∅ or [a] = [b]")),
                DmgtTopic("u2_t4", 2, "Transitive Closure & Warshall's Algorithm", "Finding the smallest transitive relation containing R.", listOf("Transitive Closure R^+", "Zero-One Matrix", "Warshall's"), listOf("W_k[i,j] = W_{k-1}[i,j] ∨ (W_{k-1}[i,k] ∧ W_{k-1}[k,j])")),
                DmgtTopic("u2_t5", 2, "Partial Ordering & Hasse Diagrams", "POSETs, drawing Hasse diagrams, maximal/minimal, LUB and GLB.", listOf("Partial Order", "Hasse Diagram", "LUB (Supremum)", "GLB (Infimum)"), listOf("a ≤ b in POSET")),
                DmgtTopic("u2_t6", 2, "Functions, Bijections & Composition", "One-to-one, onto, inverse functions, and recursive definitions.", listOf("Injective", "Surjective", "Bijective", "Composite f ∘ g"), listOf("(f ∘ g)(x) = f(g(x))")),
                DmgtTopic("u2_t7", 2, "Lattices and their Properties", "POSET where every pair has a unique LUB (join ∨) and GLB (meet ∧).", listOf("Lattice", "Distributive Lattice", "Complemented Lattice", "Boolean Algebra"), listOf("a ∧ (a ∨ b) = a (Absorption)"))
            ),
            questionCount = 10,
            formulaCount = 7
        ),
        DmgtUnit(
            unitNumber = 3,
            title = "Combinatorics & Recurrence",
            subtitle = "Counting, Generating Functions & Recurrence",
            description = "Basis of counting, permutations, combinations, binomial & multinomial theorems, generating functions, and homogeneous/inhomogeneous recurrence relations.",
            topics = listOf(
                DmgtTopic("u3_t1", 3, "Basis of Counting (Sum & Product Rule)", "Fundamental principles of addition and multiplication.", listOf("Sum Rule", "Product Rule", "Pigeonhole Principle"), listOf("Total = n1 + n2, or n1 × n2")),
                DmgtTopic("u3_t2", 3, "Permutations & Combinations", "Arrangements with repetitions, circular permutations, selections.", listOf("P(n,r)", "C(n,r)", "Circular Permutations: (n-1)!"), listOf("nCr = n! / (r!(n-r)!)")),
                DmgtTopic("u3_t3", 3, "Binomial & Multinomial Theorems", "Expansion coefficients and identities.", listOf("Pascal's Identity", "Binomial Expansion", "Multinomial Coefficients"), listOf("(x+y)^n = ∑ nCr x^(n-r) y^r")),
                DmgtTopic("u3_t4", 3, "Generating Functions & Sequences", "Representing sequences as formal power series and partial fractions.", listOf("G(x) = ∑ a_n x^n", "Partial Fractions", "Coefficient Calculation"), listOf("1/(1-x) = ∑ x^n")),
                DmgtTopic("u3_t5", 3, "Recurrence Relations: Formulation", "Modeling problems recursively (Fibonacci, Tower of Hanoi).", listOf("Formulation", "Boundary conditions"), listOf("a_n = a_{n-1} + a_{n-2}")),
                DmgtTopic("u3_t6", 3, "Solving Recurrence: Characteristic Roots", "Solving linear homogeneous relations via auxiliary equations.", listOf("Characteristic Equation", "Real distinct roots", "Repeated roots"), listOf("ar^2 + br + c = 0")),
                DmgtTopic("u3_t7", 3, "Inhomogeneous Recurrence Relations", "Particular solutions for polynomials, exponentials, and generating functions.", listOf("Homogeneous solution a_n^(h)", "Particular solution a_n^(p)"), listOf("a_n = a_n^(h) + a_n^(p)"))
            ),
            questionCount = 11,
            formulaCount = 9
        ),
        DmgtUnit(
            unitNumber = 4,
            title = "Graph Theory",
            subtitle = "Graph Fundamentals, Matrices & Traversals",
            description = "Basic graph concepts, handshaking theorem, degrees, adjacency & incidence matrices, isomorphism, paths, circuits, Euler and Hamiltonian graphs.",
            topics = listOf(
                DmgtTopic("u4_t1", 4, "Basic Graph Concepts & Handshaking", "Vertices, edges, degrees, and Handshaking Theorem.", listOf("Simple Graph", "Degree deg(v)", "Handshaking Theorem"), listOf("∑ deg(v) = 2|E|")),
                DmgtTopic("u4_t2", 4, "Graph Representations (Adjacency & Incidence)", "Matrix representations of graphs and digraphs.", listOf("Adjacency Matrix A(G)", "Incidence Matrix M(G)", "In-degree & Out-degree"), listOf("A[i,j] = number of edges between vi and vj")),
                DmgtTopic("u4_t3", 4, "Subgraphs & Isomorphic Graphs", "Preserving vertex adjacencies and structural invariants.", listOf("Isomorphism", "Degree sequence invariant", "Subgraphs"), listOf("f(u) adj f(v) ⇔ u adj v")),
                DmgtTopic("u4_t4", 4, "Paths, Circuits & Connectedness", "Walks, trails, paths, cycles, and connected components.", listOf("Walk", "Path", "Cycle", "Connected Component"), listOf("Length of path = number of edges")),
                DmgtTopic("u4_t5", 4, "Eulerian Graphs", "Traversing every edge exactly once.", listOf("Euler Trail", "Euler Circuit", "Euler's Theorem for degree parity"), listOf("Euler circuit ⇔ all vertices have even degree")),
                DmgtTopic("u4_t6", 4, "Hamiltonian Graphs", "Visiting every vertex exactly once.", listOf("Hamiltonian Path", "Hamiltonian Cycle", "Dirac's Theorem", "Ore's Theorem"), listOf("deg(v) ≥ n/2 ⇒ Hamiltonian")),
                DmgtTopic("u4_t7", 4, "Graph Complement & Special Graphs", "Complete graphs Kn, cycles Cn, complement graph G-bar.", listOf("Complete graph Kn", "Complement G-bar"), listOf("|E(G-bar)| = n(n-1)/2 - |E(G)|"))
            ),
            questionCount = 10,
            formulaCount = 7
        ),
        DmgtUnit(
            unitNumber = 5,
            title = "Multi Graphs & Trees",
            subtitle = "Planarity, Coloring, Trees & MST Algorithms",
            description = "Bipartite graphs, planar graphs (Euler's formula V - E + R = 2), graph coloring, trees, spanning trees, Prim's and Kruskal's algorithms, BFS and DFS trees.",
            topics = listOf(
                DmgtTopic("u5_t1", 5, "Multigraphs & Bipartite Graphs", "Multiple edges and 2-colorable vertex sets.", listOf("Multigraph", "Bipartite Graph K_{m,n}", "Odd cycle condition"), listOf("Bipartite ⇔ No odd cycle")),
                DmgtTopic("u5_t2", 5, "Planar Graphs & Euler's Formula", "Graphs embeddable in plane without edge crossings.", listOf("Planar Graph", "Faces/Regions (R)", "Euler's Formula"), listOf("V - E + R = 2")),
                DmgtTopic("u5_t3", 5, "Kuratowski's Theorem & Planarity Bounds", "Characterizing non-planar graphs using K5 and K3,3.", listOf("Kuratowski's Theorem", "Planarity inequality E ≤ 3V - 6"), listOf("E ≤ 3V - 6 for simple planar graphs")),
                DmgtTopic("u5_t4", 5, "Graph Coloring & Chromatic Number", "Assigning colors such that adjacent vertices differ.", listOf("Vertex Coloring", "Chromatic Number χ(G)", "Four Color Theorem"), listOf("χ(Kn) = n, χ(Bipartite) = 2")),
                DmgtTopic("u5_t5", 5, "Trees and their Fundamental Properties", "Connected acyclic graphs with n-1 edges.", listOf("Tree properties", "Leaf node", "Cayley's formula"), listOf("|E| = |V| - 1")),
                DmgtTopic("u5_t6", 5, "Minimum Spanning Trees: Kruskal & Prim", "Greedy algorithms for finding minimum weight spanning trees.", listOf("Prim's Algorithm", "Kruskal's Algorithm", "Disjoint Sets"), listOf("Time complexity: O(E log V)")),
                DmgtTopic("u5_t7", 5, "BFS & DFS Spanning Trees", "Generating spanning trees via breadth-first and depth-first searches.", listOf("BFS Tree (queue)", "DFS Tree (stack)", "Back edges & Cross edges"), listOf("Tree edges + Non-tree edges"))
            ),
            questionCount = 11,
            formulaCount = 8
        )
    )
}
