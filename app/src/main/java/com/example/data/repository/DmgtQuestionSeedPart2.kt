package com.example.data.repository

import com.example.data.models.DmgtQuestion

object DmgtQuestionSeedPart2 {

    val additionalQuestions: List<DmgtQuestion> = listOf(
        // UNIT 1: Predicate Logic
        DmgtQuestion(
            id = "q_u1_03",
            unitNumber = 1,
            unitTitle = "Mathematical Logic",
            sourceRef = "R23 Question Bank - Unit I, Q7 (5-Marks)",
            questionText = "Show that (∀x)(P(x) → Q(x)) and (∀x)P(x) logically imply (∀x)Q(x) using rules of inference in Predicate Calculus.",
            marks = 5,
            questionType = "5-Mark",
            difficulty = "Medium",
            topic = "Predicate Calculus & Quantifiers",
            simpleDefinition = "Inference in predicate calculus utilizes quantification rules (Universal Specification US and Universal Generalization UG) along with propositional rules like Modus Ponens to formally validate arguments.",
            formula = "(∀x)(P(x) → Q(x)), (∀x)P(x) ⊢ (∀x)Q(x)",
            symbolMeanings = listOf(
                "∀x" to "Universal Quantifier: 'for all x in the universe of discourse'",
                "P(x), Q(x)" to "Predicate formulas with free variable x",
                "US" to "Rule of Universal Specification: (∀x)A(x) ⇒ A(c) for an arbitrary constant c",
                "UG" to "Rule of Universal Generalization: A(c) for arbitrary c ⇒ (∀x)A(x)",
                "Rule P" to "Premise introduction rule",
                "Rule T" to "Tautological implication rule (e.g. Modus Ponens)"
            ),
            lineByLineExplanation = listOf(
                "Line 1: Introduce premise (1): (∀x)(P(x) → Q(x)) [Rule P].",
                "Line 2: Apply Universal Specification (US) to line 1 for arbitrary constant c: P(c) → Q(c).",
                "Line 3: Introduce premise (2): (∀x)P(x) [Rule P].",
                "Line 4: Apply Universal Specification (US) to line 3 for the same constant c: P(c).",
                "Line 5: From line 2 (P(c) → Q(c)) and line 4 (P(c)), apply Modus Ponens: Q(c) [Rule T].",
                "Line 6: Since c was arbitrary and not bound to any specific condition, generalize via UG: (∀x)Q(x)."
            ),
            stepByStepSolution = listOf(
                "Step 1: Write step 1 in standard proof table:\n{1} (1) (∀x)(P(x) → Q(x)) - Rule P.",
                "Step 2: Apply Rule US to (1):\n{1} (2) P(c) → Q(c) - Rule US, (1), where c is arbitrary.",
                "Step 3: Introduce second premise:\n{3} (3) (∀x)P(x) - Rule P.",
                "Step 4: Apply Rule US to (3):\n{3} (4) P(c) - Rule US, (3).",
                "Step 5: Apply Modus Ponens on (2) and (4):\n{1, 3} (5) Q(c) - Rule T, (2), (4), Modus Ponens (P ∧ (P → Q) ⇒ Q).",
                "Step 6: Apply Universal Generalization on (5):\n{1, 3} (6) (∀x)Q(x) - Rule UG, (5)."
            ),
            whyStepUsed = listOf(
                "Steps 2 and 4 remove the universal quantifiers so propositional logic rules can be used on atomic statements.",
                "Step 5 applies Modus Ponens to derive the instance Q(c).",
                "Step 6 re-quantifies with ∀ because c was chosen arbitrarily without restrictions."
            ),
            easyExample = "All humans are mortal (∀x(H(x)→M(x))). Socrates is human (H(s)). Socrates is mortal (M(s)).",
            examStyleExample = "Format as a 4-column proof table: Line Number, Preconditions/Premise set, Expression, Justification Rule.",
            twoMarkAnswer = "Proof uses Universal Specification (US) to drop ∀x yielding P(c) → Q(c) and P(c). By Modus Ponens, Q(c) is derived. By Universal Generalization (UG), (∀x)Q(x) is established.",
            fiveMarkAnswer = "Formal Proof Table:\n1. (∀x)(P(x) → Q(x)) [Rule P]\n2. P(c) → Q(c) [Rule US, 1; c is arbitrary]\n3. (∀x)P(x) [Rule P]\n4. P(c) [Rule US, 3]\n5. Q(c) [Rule T, 2 & 4, Modus Ponens]\n6. (∀x)Q(x) [Rule UG, 5]\nConclusion: (∀x)Q(x) is validly inferred.",
            tenMarkAnswer = "Complete Predicate Inference Analysis & Detailed Table:\n1. Theoretical Framework of Predicate Logic Proofs:\nRules of Predicate Calculus:\n- Rule US (Universal Specification): From (∀x)A(x), we can conclude A(c) for any arbitrary element c in the universe.\n- Rule UG (Universal Generalization): From A(c), where c is an arbitrary element, we can infer (∀x)A(x).\n- Rule P: A premise can be introduced at any stage.\n- Rule T: A tautological implication may be applied to previous lines.\n\n2. Formal Derivation Table:\n| Step | Dependencies | Statement | Justification Rule |\n|---|---|---|---|\n| (1) | {1} | (∀x)(P(x) → Q(x)) | Rule P (Premise 1) |\n| (2) | {1} | P(c) → Q(c) | Rule US on (1), c arbitrary |\n| (3) | {3} | (∀x)P(x) | Rule P (Premise 2) |\n| (4) | {3} | P(c) | Rule US on (3), c same arbitrary |\n| (5) | {1, 3} | Q(c) | Rule T on (2), (4) by Modus Ponens |\n| (6) | {1, 3} | (∀x)Q(x) | Rule UG on (5), valid as c is arbitrary |\n\n3. Verification of Restrictions on UG:\n- c does not appear free in any premises used to derive line (5).\n- Hence, the generalization to all x is completely sound and valid.",
            commonMistakes = listOf(
                "Using different arbitrary constants (e.g. c for P and d for Q). They must be the same constant c.",
                "Applying UG when the constant was introduced via Existential Specification (ES)."
            ),
            finalAnswer = "(∀x)Q(x) is validly derived using Rules P, US, Modus Ponens, and UG.",
            shortcutTip = "US strips the quantifier (∀x), propositional logic proves the core, UG restores the quantifier!",
            similarPracticeQuestion = "Show that (∃x)P(x) ∧ (∀x)(P(x) → Q(x)) logically implies (∃x)Q(x)."
        ),
        // UNIT 2: Equivalence Relations
        DmgtQuestion(
            id = "q_u2_03",
            unitNumber = 2,
            unitTitle = "Set Theory",
            sourceRef = "R23 Question Bank - Unit II, Q3 (5-Marks)",
            questionText = "Define an Equivalence Relation. Prove that the relation R on the set of integers ℤ defined by a R b if and only if (a - b) is divisible by 5 is an equivalence relation. Find the equivalence classes.",
            marks = 5,
            questionType = "5-Mark",
            difficulty = "Medium",
            topic = "Equivalence Relations & Partitions",
            simpleDefinition = "A relation is an Equivalence Relation if it is Reflexive, Symmetric, and Transitive. It partitions the set into disjoint equivalence classes.",
            formula = "a R b ⇔ 5 | (a - b) ⇔ a ≡ b (mod 5)",
            symbolMeanings = listOf(
                "ℤ" to "Set of integers {..., -2, -1, 0, 1, 2, ...}",
                "5 | (a - b)" to "5 divides (a - b), meaning a - b = 5k for some integer k",
                "[r]" to "Equivalence class of remainder r modulo 5"
            ),
            lineByLineExplanation = listOf(
                "Line 1: Reflexive: For any a ∈ ℤ, a - a = 0 = 5(0). Since 5 divides 0, a R a holds for all a.",
                "Line 2: Symmetric: Assume a R b, so a - b = 5k for k ∈ ℤ.",
                "Line 3: Then b - a = -(a - b) = -5k = 5(-k). Since -k ∈ ℤ, 5 divides (b - a), so b R a.",
                "Line 4: Transitive: Assume a R b and b R c, so a - b = 5k and b - c = 5m.",
                "Line 5: Adding equations: (a - b) + (b - c) = a - c = 5(k + m).",
                "Line 6: Since k + m ∈ ℤ, 5 divides (a - c), so a R c.",
                "Line 7: Since R is reflexive, symmetric, and transitive, R is an equivalence relation.",
                "Line 8: Remainders when divided by 5 are 0, 1, 2, 3, 4. There are 5 equivalence classes [0], [1], [2], [3], [4]."
            ),
            stepByStepSolution = listOf(
                "Step 1: Reflexivity: Let a ∈ ℤ. a - a = 0 = 5 × 0. Thus 5 | (a - a) ⇒ a R a. Reflexive holds.",
                "Step 2: Symmetry: Let a, b ∈ ℤ and assume a R b. Then a - b = 5k for some k ∈ ℤ. Multiply by -1: b - a = -(5k) = 5(-k). Since -k is an integer, 5 | (b - a) ⇒ b R a. Symmetric holds.",
                "Step 3: Transitivity: Let a, b, c ∈ ℤ and assume a R b and b R c. Then a - b = 5k and b - c = 5m for k, m ∈ ℤ. Sum: (a - b) + (b - c) = a - c = 5(k + m). Since (k + m) ∈ ℤ, 5 | (a - c) ⇒ a R c. Transitive holds.",
                "Step 4: Conclusion: R is an Equivalence Relation on ℤ.",
                "Step 5: Determine Equivalence Classes:\n[0] = {..., -10, -5, 0, 5, 10, ...} = {5k | k ∈ ℤ}\n[1] = {..., -9, -4, 1, 6, 11, ...} = {5k + 1 | k ∈ ℤ}\n[2] = {..., -8, -3, 2, 7, 12, ...} = {5k + 2 | k ∈ ℤ}\n[3] = {..., -7, -2, 3, 8, 13, ...} = {5k + 3 | k ∈ ℤ}\n[4] = {..., -6, -1, 4, 9, 14, ...} = {5k + 4 | k ∈ ℤ}."
            ),
            whyStepUsed = listOf(
                "Testing each of the three axioms (Reflexive, Symmetric, Transitive) is the definitive test for an equivalence relation.",
                "Finding remainders 0 to 4 follows from the Division Algorithm on integers."
            ),
            easyExample = "12 - 2 = 10, which is divisible by 5, so 12 R 2. Both belong to [2].",
            examStyleExample = "Prove each property under a clear sub-heading: (i) Reflexive, (ii) Symmetric, (iii) Transitive. List the 5 equivalence classes at the end.",
            twoMarkAnswer = "Equivalence Relation: Reflexive, Symmetric, and Transitive.\nProof: a-a=0=5(0) (Reflexive); a-b=5k ⇒ b-a=5(-k) (Symmetric); a-b=5k, b-c=5m ⇒ a-c=5(k+m) (Transitive).\nClasses: [0], [1], [2], [3], [4].",
            fiveMarkAnswer = "1. Definition: A relation is an equivalence relation if it is Reflexive, Symmetric, and Transitive.\n2. Proof:\n- Reflexive: ∀ a ∈ ℤ, a - a = 0 = 5(0) ⇒ a R a.\n- Symmetric: a R b ⇒ a - b = 5k ⇒ b - a = 5(-k) ⇒ b R a.\n- Transitive: a R b ∧ b R c ⇒ a - b = 5k, b - c = 5m ⇒ a - c = 5(k+m) ⇒ a R c.\n3. Equivalence Classes:\nℤ/R = {[0], [1], [2], [3], [4]} where [r] = {5k + r | k ∈ ℤ}.",
            tenMarkAnswer = "Comprehensive 10-Mark Academic Proof:\n1. Formal Theory of Equivalence Relations:\nA binary relation R on a set A is an equivalence relation iff:\n(i) Reflexivity: ∀ x ∈ A, (x, x) ∈ R\n(ii) Symmetry: ∀ x, y ∈ A, (x, y) ∈ R ⇒ (y, x) ∈ R\n(iii) Transitivity: ∀ x, y, z ∈ A, (x, y) ∈ R ∧ (y, z) ∈ R ⇒ (x, z) ∈ R\n\n2. Proof for Modulo 5 Congruence:\nGiven: a R b ⇔ 5 | (a - b) ⇔ a - b = 5k for some k ∈ ℤ.\n\nProperty 1: Reflexive\nLet a ∈ ℤ be arbitrary.\na - a = 0 = 5 × 0.\nSince 0 ∈ ℤ, 5 divides (a - a).\nTherefore, (a, a) ∈ R for all a ∈ ℤ.\n\nProperty 2: Symmetric\nLet a, b ∈ ℤ and assume (a, b) ∈ R.\nThen a - b = 5k for some integer k.\nMultiply both sides by -1:\n-(a - b) = -(5k)\nb - a = 5(-k)\nSince k ∈ ℤ, -k is also an integer.\nHence, 5 divides (b - a), meaning (b, a) ∈ R.\n\nProperty 3: Transitive\nLet a, b, c ∈ ℤ and assume (a, b) ∈ R and (b, c) ∈ R.\nThen:\na - b = 5k_1  (for some k_1 ∈ ℤ)\nb - c = 5k_2  (for some k_2 ∈ ℤ)\nAdding these two equations:\n(a - b) + (b - c) = 5k_1 + 5k_2\na - c = 5(k_1 + k_2)\nSince integers are closed under addition, (k_1 + k_2) ∈ ℤ.\nThus, 5 divides (a - c), which implies (a, c) ∈ R.\n\n3. Fundamental Theorem of Equivalence Relations:\nAny equivalence relation on a set A induces a partition of A into pairwise disjoint, non-empty subsets called equivalence classes whose union is A.\n\n4. Determination of Equivalence Classes:\nBy the Euclidean Division Algorithm, for any integer a, when divided by 5, remainder r ∈ {0, 1, 2, 3, 4}.\n- [0] = {a ∈ ℤ | a ≡ 0 (mod 5)} = {..., -10, -5, 0, 5, 10, ...}\n- [1] = {a ∈ ℤ | a ≡ 1 (mod 5)} = {..., -9, -4, 1, 6, 11, ...}\n- [2] = {a ∈ ℤ | a ≡ 2 (mod 5)} = {..., -8, -3, 2, 7, 12, ...}\n- [3] = {a ∈ ℤ | a ≡ 3 (mod 5)} = {..., -7, -2, 3, 8, 13, ...}\n- [4] = {a ∈ ℤ | a ≡ 4 (mod 5)} = {..., -6, -1, 4, 9, 14, ...}\nNotice: [0] ∪ [1] ∪ [2] ∪ [3] ∪ [4] = ℤ, and classes are mutually disjoint.",
            commonMistakes = listOf(
                "Assuming k must be positive. k can be any integer, positive, zero, or negative.",
                "Missing the negative integers when writing out the equivalence classes."
            ),
            finalAnswer = "R is an equivalence relation. The 5 equivalence classes are [0], [1], [2], [3], [4].",
            shortcutTip = "Any relation of the form 'a - b is divisible by m' is ALWAYS an equivalence relation (called congruence modulo m) with m classes: [0], [1], ..., [m-1]!",
            similarPracticeQuestion = "Show that the relation 'a - b is divisible by 4' is an equivalence relation on ℤ."
        ),
        // UNIT 3: Combinatorics
        DmgtQuestion(
            id = "q_u3_02",
            unitNumber = 3,
            unitTitle = "Combinatorics & Recurrence",
            sourceRef = "R23 Question Bank - Unit III, Q2 (5-Marks)",
            questionText = "Find the number of arrangements of the letters in the word 'ENGINEERING'. How many of these arrangements start with 'E' and end with 'G'?",
            marks = 5,
            questionType = "5-Mark",
            difficulty = "Medium",
            topic = "Permutations & Combinations",
            simpleDefinition = "Permutations of n objects where objects are repeated are calculated by dividing n! by the factorials of the repetitions of each distinct object.",
            formula = "N = n! / (n_1! n_2! ... n_k!)",
            symbolMeanings = listOf(
                "n" to "Total number of letters (11 in 'ENGINEERING')",
                "n_1" to "Repetition count of E (3)",
                "n_2" to "Repetition count of N (3)",
                "n_3" to "Repetition count of G (2)",
                "n_4" to "Repetition count of I (2)",
                "n_5" to "Repetition count of R (1)"
            ),
            lineByLineExplanation = listOf(
                "Line 1: Word: E-N-G-I-N-E-E-R-I-N-G. Total length n = 11.",
                "Line 2: Count of each letter: E = 3, N = 3, G = 2, I = 2, R = 1.",
                "Line 3: Check: 3 + 3 + 2 + 2 + 1 = 11.",
                "Line 4: Total arrangements = 11! / (3! · 3! · 2! · 2! · 1!).",
                "Line 5: 11! = 39,916,800. Denominator = 6 × 6 × 2 × 2 × 1 = 144.",
                "Line 6: Total arrangements = 39,916,800 / 144 = 277,200.",
                "Line 7: For condition 'starts with E and ends with G': fix E in position 1 and G in position 11.",
                "Line 8: Remaining letters to arrange: 11 - 2 = 9 letters.",
                "Line 9: Remaining counts: E = 2, N = 3, G = 1, I = 2, R = 1 (sum = 9).",
                "Line 10: Arrangements = 9! / (2! · 3! · 1! · 2! · 1!) = 362,880 / (2 × 6 × 1 × 2 × 1) = 362,880 / 24 = 15,120."
            ),
            stepByStepSolution = listOf(
                "Step 1: Count total letters in ENGINEERING: n = 11.",
                "Step 2: Find frequency of each letter:\nE: 3, N: 3, G: 2, I: 2, R: 1.",
                "Step 3: Apply the Permutation with Repetition formula:\nTotal arrangements = 11! / (3! 3! 2! 2! 1!).",
                "Step 4: Compute value:\n= (39,916,800) / (6 × 6 × 2 × 2) = 39,916,800 / 144 = 277,200.",
                "Step 5: Case: Starts with 'E' and ends with 'G':\nFix 'E' in 1st spot and 'G' in last (11th) spot.\nLetters left = 9 letters.",
                "Step 6: Counts of remaining 9 letters:\nE: 2 (since 1 is fixed)\nN: 3\nG: 1 (since 1 is fixed)\nI: 2\nR: 1.",
                "Step 7: Compute restricted arrangements:\n= 9! / (2! 3! 1! 2! 1!) = 362,880 / (2 × 6 × 1 × 2 × 1) = 362,880 / 24 = 15,120."
            ),
            whyStepUsed = listOf(
                "Dividing by factorials corrects for overcounting identical permutations of repeated letters.",
                "Fixing first and last positions reduces the problem to arranging the remaining 9 letters."
            ),
            easyExample = "Arranging 'MOM': 3 letters, 2 M's. 3! / 2! = 3 ways: MOM, MMO, OMM.",
            examStyleExample = "Write the general formula first, state each letter count clearly, show cancellation of factorials before final arithmetic.",
            twoMarkAnswer = "Formula: n! / (p! q! r!...)\nTotal = 11! / (3! 3! 2! 2! 1!) = 277,200.\nStarting with E, ending with G = 9! / (2! 3! 1! 2! 1!) = 15,120.",
            fiveMarkAnswer = "1. Given Word: ENGINEERING (11 letters)\nFrequencies: E:3, N:3, G:2, I:2, R:1.\nTotal permutations = 11! / (3! 3! 2! 2! 1!) = 39,916,800 / 144 = 277,200.\n\n2. Restricted: Starts with E, ends with G:\nFixed: E _ _ _ _ _ _ _ _ _ G\nRemaining 9 letters: E:2, N:3, G:1, I:2, R:1.\nWays = 9! / (2! 3! 1! 2! 1!) = 362,880 / 24 = 15,120.",
            tenMarkAnswer = "Detailed Permutations with Repetition Solution:\n1. Combinatorial Principle:\nWhen arranging n items where n_1 are of type 1, n_2 of type 2, ..., n_k of type k, the number of distinct permutations is given by the Multinomial Coefficient:\nN = n! / (n_1! n_2! ... n_k!), where ∑ n_i = n.\n\n2. Analysis of the word 'ENGINEERING':\nTotal characters = 11\nCharacter Breakdown:\n- 'E': 3 occurrences\n- 'N': 3 occurrences\n- 'G': 2 occurrences\n- 'I': 2 occurrences\n- 'R': 1 occurrence\nSum = 3 + 3 + 2 + 2 + 1 = 11.\n\nTotal Arrangements Calculation:\nTotal = 11! / (3! × 3! × 2! × 2! × 1!)\n= (11 × 10 × 9 × 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1) / ((6) × (6) × (2) × (2) × (1))\n= 39,916,800 / 144 = 277,200.\n\n3. Restricted Arrangements:\nCondition: Word must start with 'E' and end with 'G'.\nConfiguration: E [ _ _ _ _ _ _ _ _ _ ] G (9 blank spaces to fill)\nRemaining available letters:\n- E: 3 - 1 = 2\n- N: 3\n- G: 2 - 1 = 1\n- I: 2\n- R: 1\nTotal remaining = 2 + 3 + 1 + 2 + 1 = 9 letters.\n\nPermutations of remaining letters:\n= 9! / (2! × 3! × 1! × 2! × 1!)\n= 362,880 / (2 × 6 × 1 × 2 × 1)\n= 362,880 / 24 = 15,120.\n\nFinal Results:\n- Total unrestricted arrangements: 277,200\n- Arrangements starting with E and ending with G: 15,120.",
            commonMistakes = listOf(
                "Forgetting to decrement the counts of E and G in the second part.",
                "Miscounting the number of letters in ENGINEERING as 10 instead of 11."
            ),
            finalAnswer = "Total = 277,200 arrangements; Starting with E and ending with G = 15,120 arrangements.",
            shortcutTip = "Cancel 3! (6) with 6 in the numerator before multiplying large numbers!",
            similarPracticeQuestion = "Find the arrangements of 'MATHEMATICS'. How many have all vowels together?"
        ),
        // UNIT 4: Graph Theory - Matrices & Isomorphism
        DmgtQuestion(
            id = "q_u4_02",
            unitNumber = 4,
            unitTitle = "Graph Theory",
            sourceRef = "R23 Question Bank - Unit IV, Q4 (5-Marks)",
            questionText = "Define Adjacency Matrix and Incidence Matrix of a simple graph with an example. For a triangle graph with vertices v1, v2, v3, construct both matrices.",
            marks = 5,
            questionType = "5-Mark",
            difficulty = "Easy",
            topic = "Graph Representations (Adjacency & Incidence)",
            simpleDefinition = "An Adjacency Matrix A = [a_ij] has a_ij = 1 if an edge connects v_i and v_j, else 0. An Incidence Matrix M = [m_ij] has m_ij = 1 if vertex v_i is an endpoint of edge e_j, else 0.",
            formula = "A(G) is n × n symmetric matrix; M(G) is n × m matrix with column sum = 2",
            symbolMeanings = listOf(
                "n" to "Number of vertices (|V| = 3)",
                "m" to "Number of edges (|E| = 3 for triangle)",
                "a_ij" to "Entry at row i, col j of Adjacency matrix",
                "m_ij" to "Entry at row i, col j of Incidence matrix"
            ),
            lineByLineExplanation = listOf(
                "Line 1: Triangle K3 has 3 vertices {v1, v2, v3} and 3 edges e1=(v1,v2), e2=(v2,v3), e3=(v1,v3).",
                "Line 2: Adjacency Matrix A is 3 × 3. Diagonals are 0 because there are no self-loops in simple graphs.",
                "Line 3: Row 1: v1 is adjacent to v2 and v3: [0, 1, 1].",
                "Line 4: Row 2: v2 is adjacent to v1 and v3: [1, 0, 1].",
                "Line 5: Row 3: v3 is adjacent to v1 and v2: [1, 1, 0].",
                "Line 6: Incidence Matrix M has vertices as rows (v1, v2, v3) and edges as columns (e1, e2, e3).",
                "Line 7: e1 connects v1, v2: Col 1 is [1, 1, 0]^T.",
                "Line 8: e2 connects v2, v3: Col 2 is [0, 1, 1]^T.",
                "Line 9: e3 connects v1, v3: Col 3 is [1, 0, 1]^T.",
                "Line 10: Notice every column of the Incidence Matrix sums to exactly 2."
            ),
            stepByStepSolution = listOf(
                "Step 1: Define Adjacency Matrix A(G):\nLet G = (V, E) have vertices v1, ..., vn. The adjacency matrix A = [a_ij] is an n × n matrix where:\na_ij = 1 if (vi, vj) ∈ E, and 0 otherwise.\nFor undirected graphs, A(G) is always symmetric (A = A^T).",
                "Step 2: Define Incidence Matrix M(G):\nLet G have vertices v1, ..., vn and edges e1, ..., em. The incidence matrix M = [m_ij] is an n × m matrix where:\nm_ij = 1 if vertex vi is incident on edge ej, and 0 otherwise.\nEvery column in M(G) contains exactly two 1's.",
                "Step 3: Triangle Graph (K3):\nVertices: V = {v1, v2, v3}\nEdges: e1 = (v1, v2), e2 = (v2, v3), e3 = (v1, v3).",
                "Step 4: Construct Adjacency Matrix A:\n    v1  v2  v3\nv1 [ 0   1   1 ]\nv2 [ 1   0   1 ]\nv3 [ 1   1   0 ]",
                "Step 5: Construct Incidence Matrix M:\n    e1  e2  e3\nv1 [ 1   0   1 ]\nv2 [ 1   1   0 ]\nv3 [ 0   1   1 ]"
            ),
            whyStepUsed = listOf(
                "Adjacency matrix gives immediate O(1) edge lookup.",
                "Incidence matrix represents the boundary operator between 0-cells (vertices) and 1-cells (edges)."
            ),
            easyExample = "Single edge v1-v2: A = [[0, 1], [1, 0]], M = [[1], [1]].",
            examStyleExample = "Draw the triangle graph, write definitions with formal conditions, draw the 3x3 adjacency and 3x3 incidence matrices clearly.",
            twoMarkAnswer = "Adjacency Matrix A(G): n × n matrix where a_ij = 1 if edge (vi, vj) exists, 0 otherwise.\nIncidence Matrix M(G): n × m matrix where m_ij = 1 if vertex vi is on edge ej, 0 otherwise. Column sum is always 2.",
            fiveMarkAnswer = "1. Adjacency Matrix A(G):\nSquare matrix of size |V| × |V|.\na_ij = 1 if {vi, vj} ∈ E, else 0.\nFor triangle K3 with edges (v1,v2), (v2,v3), (v1,v3):\nA =\n[0  1  1]\n[1  0  1]\n[1  1  0]\n\n2. Incidence Matrix M(G):\nMatrix of size |V| × |E|.\nm_ij = 1 if vi is incident on ej, else 0.\nColumns for e1(v1,v2), e2(v2,v3), e3(v1,v3):\nM =\n[1  0  1] (v1)\n[1  1  0] (v2)\n[0  1  1] (v3)",
            tenMarkAnswer = "Comprehensive Graph Matrix Representations:\n1. Adjacency Matrix Properties:\n- Size: n × n (where n = |V|).\n- Symmetric for undirected graphs: a_ij = a_ji.\n- Main diagonal entries are 0 for simple graphs (no self loops).\n- The sum of entries in row i equals deg(v_i): ∑_j a_ij = deg(v_i).\n- Matrix power (A^k)_ij gives the number of walks of length k between v_i and v_j.\n\n2. Incidence Matrix Properties:\n- Size: n × m (where n = |V|, m = |E|).\n- Entries are strictly in {0, 1} for simple graphs.\n- Every column has exactly two 1's (representing the two endpoints of that edge).\n- Column sum = 2.\n- Row sum for row i equals deg(v_i): ∑_j m_ij = deg(v_i).\n\n3. Triangle Graph K3 Example:\nVertices V = {v1, v2, v3}, Edges E = {e1=(v1,v2), e2=(v2,v3), e3=(v1,v3)}.\nAdjacency Matrix:\n     v1  v2  v3\nv1 [  0   1   1 ]\nv2 [  1   0   1 ]\nv3 [  1   1   0 ]\nRow sums: 2, 2, 2 (each vertex has degree 2).\n\nIncidence Matrix:\n     e1  e2  e3\nv1 [  1   0   1 ]\nv2 [  1   1   0 ]\nv3 [  0   1   1 ]\nColumn sums: 2, 2, 2 (each edge has 2 endpoints).\nTotal 1's in M = 2|E| = 6 = total degrees.",
            commonMistakes = listOf(
                "Swapping rows and columns in the incidence matrix (rows are vertices, columns are edges).",
                "Putting 1 on the diagonal of the adjacency matrix for simple graphs."
            ),
            finalAnswer = "A is 3x3 symmetric matrix with 0 on diagonal; M is 3x3 matrix with column sum = 2.",
            shortcutTip = "In Adjacency Matrix: Row sum = Degree. In Incidence Matrix: Column sum = 2 always!",
            similarPracticeQuestion = "Write the adjacency and incidence matrix for a 4-vertex cycle graph C4."
        ),
        // UNIT 5: Graph Coloring & Chromatic Number
        DmgtQuestion(
            id = "q_u5_03",
            unitNumber = 5,
            unitTitle = "Multi Graphs & Trees",
            sourceRef = "R23 Question Bank - Unit V, Q4 (5-Marks)",
            questionText = "Define Graph Coloring and Chromatic Number χ(G). Find the chromatic number of: (i) Complete graph K_n, (ii) Bipartite graph K_{m,n}, (iii) Cycle graph C_n (for both n even and n odd).",
            marks = 5,
            questionType = "5-Mark",
            difficulty = "Medium",
            topic = "Graph Coloring & Chromatic Number",
            simpleDefinition = "Graph coloring is an assignment of colors to vertices such that no two adjacent vertices share the same color. The Chromatic Number χ(G) is the minimum number of colors required to properly color G.",
            formula = "χ(K_n) = n, χ(K_{m,n}) = 2, χ(C_n) = 2 if n is even, 3 if n is odd",
            symbolMeanings = listOf(
                "χ(G)" to "Chromatic number of graph G (pronounced 'chi of G')",
                "K_n" to "Complete graph on n vertices",
                "K_{m,n}" to "Complete bipartite graph with partition sizes m and n",
                "C_n" to "Cycle graph on n vertices"
            ),
            lineByLineExplanation = listOf(
                "Line 1: A proper vertex coloring ensures: if (u, v) ∈ E, then color(u) ≠ color(v).",
                "Line 2: (i) In K_n, every vertex is connected to all other n - 1 vertices.",
                "Line 3: Thus no two vertices can share a color. Therefore χ(K_n) = n.",
                "Line 4: (ii) In bipartite graph K_{m,n}, V is partitioned into independent sets V1 and V2.",
                "Line 5: No edges exist within V1 (assign color 1), and no edges within V2 (assign color 2).",
                "Line 6: Therefore χ(K_{m,n}) = 2 (for any non-empty bipartite graph with edges).",
                "Line 7: (iii) In cycle C_n, alternate colors: Red, Blue, Red, Blue...",
                "Line 8: If n is even, vertex n has a different color from vertex 1. 2 colors suffice: χ(C_even) = 2.",
                "Line 9: If n is odd, vertex n connects to vertex 1 and vertex n-1, both of which have different colors. A 3rd color is required: χ(C_odd) = 3."
            ),
            stepByStepSolution = listOf(
                "Step 1: Define Proper Vertex Coloring: An assignment of colors to the vertices of a graph such that no two adjacent vertices have the same color.",
                "Step 2: Define Chromatic Number χ(G): The smallest number k such that G has a proper k-coloring.",
                "Step 3: Case (i) Complete Graph K_n:\nSince every pair of vertices is connected by an edge, all n vertices must receive distinct colors. Therefore, χ(K_n) = n.",
                "Step 4: Case (ii) Complete Bipartite Graph K_{m,n} (m, n ≥ 1):\nV can be partitioned into V1 and V2 such that all edges go between V1 and V2. Color all vertices in V1 with color 1, and all in V2 with color 2. No adjacent vertices share a color. Therefore, χ(K_{m,n}) = 2.",
                "Step 5: Case (iii) Cycle Graph C_n:\n- If n is even (e.g. C4): Vertices can be 2-colored by alternating (1, 2, 1, 2). χ(C_even) = 2.\n- If n is odd (e.g. C5, C3): Alternating colors gives (1, 2, 1, 2, ...). The last vertex is adjacent to both color 1 and color 2, requiring a third color. χ(C_odd) = 3."
            ),
            whyStepUsed = listOf(
                "Checking clique size gives the lower bound for K_n.",
                "Using the bipartition property guarantees 2-colorability.",
                "Testing parity of cycles directly applies the fundamental theorem that a graph is bipartite iff it has no odd cycles."
            ),
            easyExample = "Triangle C3: requires 3 colors (χ=3). Square C4: 2 colors (Red, Blue, Red, Blue) (χ=2).",
            examStyleExample = "Write definitions first, followed by each sub-case with reasoning and final numerical formula.",
            twoMarkAnswer = "Chromatic Number χ(G): Minimum colors for proper vertex coloring.\n(i) χ(Kn) = n\n(ii) χ(Km,n) = 2\n(iii) χ(Cn) = 2 for even n, 3 for odd n.",
            fiveMarkAnswer = "1. Definitions:\n- Proper Coloring: c(u) ≠ c(v) for all (u, v) ∈ E.\n- Chromatic Number χ(G): Least k for which G is k-colorable.\n\n2. Values:\n(i) K_n: Every vertex adjacent to all others ⇒ χ(K_n) = n.\n(ii) K_{m,n}: Vertices in V1 get Color 1, V2 get Color 2 ⇒ χ(K_{m,n}) = 2.\n(iii) C_n:\n- Even n: Alternating 2 colors works ⇒ χ(C_n) = 2.\n- Odd n: Odd cycle requires 3 colors ⇒ χ(C_n) = 3.",
            tenMarkAnswer = "Exhaustive 10-Mark Academic Presentation:\n1. Graph Coloring Theory:\n- Vertex Coloring: A mapping c: V → {1, 2, ..., k} such that for every edge e = (u, v) ∈ E, c(u) ≠ c(v).\n- k-Colorable: A graph is k-colorable if it admits a proper coloring using at most k colors.\n- Chromatic Number χ(G): χ(G) = min {k | G is k-colorable}.\n\n2. Properties of Standard Graphs:\n(a) Complete Graph K_n:\nEvery vertex v_i is connected to all other n-1 vertices. Any two vertices are mutually adjacent. Hence no two vertices can share a color.\n∴ χ(K_n) = n.\nExample: K_4 requires 4 distinct colors.\n\n(b) Bipartite Graph K_{m,n}:\nA graph is bipartite if V = V_1 ∪ V_2 where no two vertices in V_1 are adjacent and no two in V_2 are adjacent.\nWe can color every vertex in V_1 with color C_1 and every vertex in V_2 with color C_2.\nSince all edges run between V_1 and V_2, adjacent vertices have different colors (C_1 and C_2).\n∴ χ(K_{m,n}) = 2 (for m, n ≥ 1).\nTheorem: A graph has χ(G) ≤ 2 iff it has no odd cycles.\n\n(c) Cycle Graph C_n:\nVertices arranged in a single closed cycle v_1, v_2, ..., v_n, v_1.\n- Case 1: n is even (e.g. n = 4, 6, 8...)\nAssign c(v_i) = 1 if i is odd, c(v_i) = 2 if i is even.\nv_n has color 2, v_1 has color 1 (different). All adjacencies are between color 1 and 2.\n∴ χ(C_n) = 2 for even n.\n- Case 2: n is odd (e.g. n = 3, 5, 7...)\nIf we alternate colors 1 and 2, v_{n-1} is colored 2, but v_n is adjacent to both v_{n-1} (color 2) and v_1 (color 1).\nThus v_n cannot be colored 1 or 2, necessitating a 3rd color.\n∴ χ(C_n) = 3 for odd n.\n\n3. Famous Related Theorems:\n- Four Color Theorem (Appel & Haken, 1976): Every planar graph is 4-colorable: χ(G) ≤ 4.\n- Brooks' Theorem: For any connected graph that is neither a complete graph nor an odd cycle, χ(G) ≤ Δ(G).",
            commonMistakes = listOf(
                "Saying χ(Cn) = 2 for all n (forgetting that odd cycles like C3 and C5 require 3 colors).",
                "Confusing vertex coloring with edge coloring (chromatic index)."
            ),
            finalAnswer = "χ(Kn) = n; χ(Km,n) = 2; χ(Cn) = 2 (n even) and 3 (n odd).",
            shortcutTip = "Bipartite = 2 colors. Even cycle = 2 colors. Odd cycle = 3 colors. Complete graph = n colors!",
            similarPracticeQuestion = "Find the chromatic number of the Wheel graph W5 and W6."
        )
    )
}
