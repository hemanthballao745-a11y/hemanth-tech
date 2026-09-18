package com.example.data.repository

import com.example.data.models.DmgtQuestion

object DmgtQuestionSeed {

    val questions: List<DmgtQuestion> = listOf(
        // UNIT 1: Logic
        DmgtQuestion(
            id = "q_u1_01",
            unitNumber = 1,
            unitTitle = "Mathematical Logic",
            sourceRef = "R23 Question Bank - Unit I, Q1 (2-Marks)",
            questionText = "Define Tautology, Contradiction, and Contingency with an example for each.",
            marks = 2,
            questionType = "2-Mark",
            difficulty = "Easy",
            topic = "Tautologies & Equivalence of Formulas",
            simpleDefinition = "A tautology is a formula that is True under all truth value assignments. A contradiction is False under all assignments. A contingency is True for some assignments and False for others.",
            formula = "Tautology: P ∨ ¬P ≡ T, Contradiction: P ∧ ¬P ≡ F",
            symbolMeanings = listOf(
                "P" to "A propositional statement variable (can be True or False)",
                "¬" to "Negation operator (NOT)",
                "∨" to "Disjunction operator (OR)",
                "∧" to "Conjunction operator (AND)",
                "≡" to "Logical equivalence operator",
                "T" to "Tautology (identically True)",
                "F" to "Contradiction (identically False)"
            ),
            lineByLineExplanation = listOf(
                "Line 1: If P is True, ¬P is False; P ∨ ¬P becomes T ∨ F = T.",
                "Line 2: If P is False, ¬P is True; P ∨ ¬P becomes F ∨ T = T.",
                "Line 3: In both cases, the result is True, hence a Tautology.",
                "Line 4: For P ∧ ¬P, if P is T then T ∧ F = F; if P is F then F ∧ T = F, hence a Contradiction."
            ),
            stepByStepSolution = listOf(
                "Step 1: Define Tautology: A compound proposition that is always True regardless of the truth values of its component propositions. Example: P ∨ ¬P.",
                "Step 2: Define Contradiction: A compound proposition that is always False. Example: P ∧ ¬P.",
                "Step 3: Define Contingency: A compound proposition that is neither a tautology nor a contradiction. Example: P → Q."
            ),
            whyStepUsed = listOf(
                "Step 1 identifies the universal truth condition required for tautology in R23 exam.",
                "Step 2 establishes the opposite falsehood condition.",
                "Step 3 completes the three-way classification of propositional formulas."
            ),
            easyExample = "P = 'It is raining'. P ∨ ¬P = 'It is raining or it is not raining' (always true).",
            examStyleExample = "Construct a 2-row truth table for P, ¬P, P ∨ ¬P, and P ∧ ¬P to demonstrate T and F outputs.",
            twoMarkAnswer = "1. Tautology: A statement formula that is always TRUE for all possible truth values of its variables. Example: P ∨ ¬P ≡ T.\n2. Contradiction: A formula that is always FALSE. Example: P ∧ ¬P ≡ F.\n3. Contingency: Neither tautology nor contradiction. Example: P ∧ Q.",
            fiveMarkAnswer = "Definition:\n- Tautology (T): Always True. Truth table last column has only T. (e.g. P ∨ ¬P).\n- Contradiction (F): Always False. Truth table last column has only F. (e.g. P ∧ ¬P).\n- Contingency: Has both T and F in final column. (e.g. P → Q).\n\nTruth Table Proof:\n| P | ¬P | P ∨ ¬P (Tautology) | P ∧ ¬P (Contradiction) |\n| T | F  | T                  | F                      |\n| F | T  | T                  | F                      |\nConclusion: P ∨ ¬P is a Tautology, P ∧ ¬P is a Contradiction.",
            tenMarkAnswer = "Comprehensive Explanation of Truth Classifications in Propositional Logic:\n\n1. Definition & Foundations:\nIn mathematical logic, a Well Formed Formula (WFF) evaluates to a truth value under truth assignments (interpretations).\n- Tautology: An identical truth formula denoted by T.\n- Contradiction: An identical falsity formula denoted by F.\n- Contingency: A formula whose truth depends on specific assignments.\n\n2. Algebraic Proof via Boolean Identities:\n- Identity Law: P ∨ F ≡ P, P ∧ T ≡ P\n- Complement Law: P ∨ ¬P ≡ T, P ∧ ¬P ≡ F\n\n3. Proof by Truth Table:\n| P | Q | P → Q | (P → Q) ∨ P |\n| T | T | T     | T           |\n| T | F | F     | T           |\n| F | T | T     | T           |\n| F | F | T     | T           |\nHence (P → Q) ∨ P is a tautology.\n\n4. Application in Inference: Tautological implications are fundamental inference rules (e.g. Modus Ponens).",
            commonMistakes = listOf(
                "Confusing Contingency with Contradiction.",
                "Forgetting to write examples alongside each definition in 2-mark answers."
            ),
            finalAnswer = "Tautology: P ∨ ¬P; Contradiction: P ∧ ¬P; Contingency: P → Q.",
            shortcutTip = "Remember: Tautology = All 'T's; Contradiction = All 'F's; Contingency = Mixed 'T's & 'F's.",
            similarPracticeQuestion = "Determine whether ((P → Q) ∧ P) → Q is a tautology, contradiction, or contingency."
        ),
        DmgtQuestion(
            id = "q_u1_02",
            unitNumber = 1,
            unitTitle = "Mathematical Logic",
            sourceRef = "R23 Question Bank - Unit I, Q4 (10-Marks)",
            questionText = "Obtain the Principal Disjunctive Normal Form (PDNF) and Principal Conjunctive Normal Form (PCNF) of (P ∧ Q) ∨ (¬P ∧ R) ∨ (Q ∧ R).",
            marks = 10,
            questionType = "10-Mark",
            difficulty = "Hard",
            topic = "Normal Forms (PDNF & PCNF)",
            simpleDefinition = "PDNF is a sum of minterms (products containing every variable or its negation). PCNF is a product of maxterms (sums containing every variable or its negation).",
            formula = "PDNF = ∑ minterms(m_i), PCNF = ∏ maxterms(M_j)",
            symbolMeanings = listOf(
                "P, Q, R" to "Three propositional variables (8 combinations: 2^3)",
                "∧" to "Conjunction (Product/AND)",
                "∨" to "Disjunction (Sum/OR)",
                "¬" to "Negation",
                "m_i" to "Minterm i where variable is unnegated if True, negated if False",
                "M_j" to "Maxterm j where variable is unnegated if False, negated if True"
            ),
            lineByLineExplanation = listOf(
                "Line 1: The given formula has 3 variables: P, Q, R. Therefore total minterms = 2^3 = 8.",
                "Line 2: Expand (P ∧ Q) by inserting missing variable R: (P ∧ Q ∧ (R ∨ ¬R)) = (P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R).",
                "Line 3: Expand (¬P ∧ R) by inserting missing variable Q: (¬P ∧ R ∧ (Q ∨ ¬Q)) = (¬P ∧ Q ∧ R) ∨ (¬P ∧ ¬Q ∧ R).",
                "Line 4: Expand (Q ∧ R) by inserting missing variable P: (Q ∧ R ∧ (P ∨ ¬P)) = (P ∧ Q ∧ R) ∨ (¬P ∧ Q ∧ R).",
                "Line 5: Combine all terms and eliminate duplicate terms using Idempotent Law (A ∨ A = A).",
                "Line 6: Minterms present: (P ∧ Q ∧ R) [m7], (P ∧ Q ∧ ¬R) [m6], (¬P ∧ Q ∧ R) [m3], (¬P ∧ ¬Q ∧ R) [m1].",
                "Line 7: PDNF = m1 ∨ m3 ∨ m6 ∨ m7.",
                "Line 8: Missing minterms are m0, m2, m4, m5. PCNF consists of maxterms corresponding to missing minterms: PCNF = M0 ∧ M2 ∧ M4 ∧ M5."
            ),
            stepByStepSolution = listOf(
                "Step 1: Identify all distinct variables in the formula. Here variables are P, Q, R (total 3 variables).",
                "Step 2: Expand each conjunct so it contains all three variables using the identity X ∧ (Y ∨ ¬Y) = (X ∧ Y) ∨ (X ∧ ¬Y).",
                "Step 3: (P ∧ Q) ≡ (P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R).",
                "Step 4: (¬P ∧ R) ≡ (¬P ∧ Q ∧ R) ∨ (¬P ∧ ¬Q ∧ R).",
                "Step 5: (Q ∧ R) ≡ (P ∧ Q ∧ R) ∨ (¬P ∧ Q ∧ R).",
                "Step 6: Combine all minterms: (P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R) ∨ (¬P ∧ Q ∧ R) ∨ (¬P ∧ ¬Q ∧ R).",
                "Step 7: In decimal minterm notation: m7 ∨ m6 ∨ m3 ∨ m1. (PDNF = ∑(1, 3, 6, 7)).",
                "Step 8: The remaining minterms are 0, 2, 4, 5. The PCNF is formed by the product of maxterms: PCNF = ∏(0, 2, 4, 5) = (P ∨ Q ∨ R) ∧ (P ∨ ¬Q ∨ R) ∧ (¬P ∨ Q ∨ R) ∧ (¬P ∨ Q ∨ ¬R)."
            ),
            whyStepUsed = listOf(
                "Step 1 ensures no variables are omitted from the canonical product terms.",
                "Step 2 uses the fundamental boolean identity A ∧ (B ∨ ¬B) = A to introduce missing variables without altering truth value.",
                "Step 6 drops redundant terms by Idempotent Law to get unique canonical form.",
                "Step 8 uses the duality principle that PCNF comprises maxterms whose indices are the complement set of PDNF minterms."
            ),
            easyExample = "For formula P ∨ Q with variables P, Q: PDNF = (P ∧ Q) ∨ (P ∧ ¬Q) ∨ (¬P ∧ Q) = ∑(1,2,3). PCNF = (P ∨ Q) = ∏(0).",
            examStyleExample = "State the given formula, write the expansion algebraically with justifications, write PDNF in both symbolic and minterm notation, then write PCNF directly from remaining indices.",
            twoMarkAnswer = "PDNF is the sum of fundamental conjunctions (minterms) containing every variable once. PCNF is the product of fundamental disjunctions (maxterms). For the given formula: PDNF = ∑(1, 3, 6, 7) and PCNF = ∏(0, 2, 4, 5).",
            fiveMarkAnswer = "Given: F = (P ∧ Q) ∨ (¬P ∧ R) ∨ (Q ∧ R)\nVariables: P, Q, R.\n1. Expanding terms:\n- P ∧ Q ≡ (P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R) [m7, m6]\n- ¬P ∧ R ≡ (¬P ∧ Q ∧ R) ∨ (¬P ∧ ¬Q ∧ R) [m3, m1]\n- Q ∧ R ≡ (P ∧ Q ∧ R) ∨ (¬P ∧ Q ∧ R) [m7, m3]\n2. Combining unique terms:\nPDNF = (¬P ∧ ¬Q ∧ R) ∨ (¬P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R) ∨ (P ∧ Q ∧ R) = ∑(1, 3, 6, 7)\n3. PCNF consists of maxterms of remaining indices {0, 2, 4, 5}:\nPCNF = (P ∨ Q ∨ R) ∧ (P ∨ ¬Q ∨ R) ∧ (¬P ∨ Q ∨ R) ∧ (¬P ∨ Q ∨ ¬R) = ∏(0, 2, 4, 5).",
            tenMarkAnswer = "Comprehensive 10-Mark Solution:\n\n1. Definition & Theory of Canonical Normal Forms:\n- PDNF (Principal Disjunctive Normal Form): An equivalent formula consisting solely of disjunction of minterms.\n- PCNF (Principal Conjunctive Normal Form): An equivalent formula consisting solely of conjunction of maxterms.\n- A formula with n variables has 2^n possible minterms and maxterms.\n\n2. Given Statement Formula:\nF(P, Q, R) = (P ∧ Q) ∨ (¬P ∧ R) ∨ (Q ∧ R)\n\n3. Step-by-Step Algebraic Derivation of PDNF:\n- First term: (P ∧ Q) ∧ (R ∨ ¬R) ≡ (P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R)\n- Second term: (¬P ∧ R) ∧ (Q ∨ ¬Q) ≡ (¬P ∧ Q ∧ R) ∨ (¬P ∧ ¬Q ∧ R)\n- Third term: (Q ∧ R) ∧ (P ∨ ¬P) ≡ (P ∧ Q ∧ R) ∨ (¬P ∧ Q ∧ R)\n\nApplying Disjunctive Union:\nF ≡ (P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R) ∨ (¬P ∧ Q ∧ R) ∨ (¬P ∧ ¬Q ∧ R) ∨ (P ∧ Q ∧ R) ∨ (¬P ∧ Q ∧ R)\nApplying Idempotent Law (X ∨ X ≡ X):\nF ≡ (¬P ∧ ¬Q ∧ R) ∨ (¬P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R) ∨ (P ∧ Q ∧ R)\n\nBinary codes & Minterm indices:\n- ¬P ∧ ¬Q ∧ R = 001_2 = m1\n- ¬P ∧ Q ∧ R  = 011_2 = m3\n- P ∧ Q ∧ ¬R  = 110_2 = m6\n- P ∧ Q ∧ R   = 111_2 = m7\n∴ PDNF = m1 ∨ m3 ∨ m6 ∨ m7 = ∑(1, 3, 6, 7)\n\n4. Derivation of PCNF:\nThe indices of maxterms for PCNF are the complement set of minterm indices from the universe {0, 1, 2, 3, 4, 5, 6, 7}.\nComplement set = {0, 2, 4, 5}.\nCorresponding Maxterms:\n- M0 (000) = (P ∨ Q ∨ R)\n- M2 (010) = (P ∨ ¬Q ∨ R)\n- M4 (100) = (¬P ∨ Q ∨ R)\n- M5 (101) = (¬P ∨ Q ∨ ¬R)\n∴ PCNF = M0 ∧ M2 ∧ M4 ∧ M5 = ∏(0, 2, 4, 5)\n\n5. Final Conclusion:\nPDNF = (¬P ∧ ¬Q ∧ R) ∨ (¬P ∧ Q ∧ R) ∨ (P ∧ Q ∧ ¬R) ∨ (P ∧ Q ∧ R)\nPCNF = (P ∨ Q ∨ R) ∧ (P ∨ ¬Q ∨ R) ∧ (¬P ∨ Q ∨ R) ∧ (¬P ∨ Q ∨ ¬R).",
            commonMistakes = listOf(
                "Negating variables incorrectly when writing maxterms (remember: unnegated variable corresponds to 0, negated to 1 in maxterms).",
                "Forgetting to eliminate duplicate minterms."
            ),
            finalAnswer = "PDNF = ∑(1, 3, 6, 7); PCNF = ∏(0, 2, 4, 5)",
            shortcutTip = "Once PDNF minterms {1, 3, 6, 7} are found, PCNF maxterms are simply the leftover numbers {0, 2, 4, 5}!",
            similarPracticeQuestion = "Obtain the PDNF and PCNF of the formula (P → (Q ∧ R)) ∧ (¬P → (¬Q ∧ ¬R))."
        ),
        // UNIT 2: Set Theory & Relations
        DmgtQuestion(
            id = "q_u2_01",
            unitNumber = 2,
            unitTitle = "Set Theory",
            sourceRef = "R23 Question Bank - Unit II, Q2 (5-Marks)",
            questionText = "State and prove the Principle of Inclusion-Exclusion for two finite sets A and B. If in a class of 100 students, 60 study Discrete Math, 45 study Java, and 20 study both, how many students study neither?",
            marks = 5,
            questionType = "5-Mark",
            difficulty = "Medium",
            topic = "Sets & Inclusion-Exclusion Principle",
            simpleDefinition = "The Principle of Inclusion-Exclusion calculates the size of the union of sets by adding individual sizes and subtracting overlaps to avoid double-counting.",
            formula = "|A ∪ B| = |A| + |B| - |A ∩ B|",
            symbolMeanings = listOf(
                "|A|" to "Cardinality (number of elements) of set A",
                "|B|" to "Cardinality of set B",
                "∪" to "Union operator (elements in A or B or both)",
                "∩" to "Intersection operator (elements in both A and B)",
                "U" to "Universal set of all students (Total = 100)"
            ),
            lineByLineExplanation = listOf(
                "Line 1: When we add |A| + |B|, the intersection elements (A ∩ B) are counted twice.",
                "Line 2: To correct for double counting, we subtract |A ∩ B| once: |A ∪ B| = |A| + |B| - |A ∩ B|.",
                "Line 3: Here |A| = 60 (Discrete Math), |B| = 45 (Java), |A ∩ B| = 20 (both).",
                "Line 4: |A ∪ B| = 60 + 45 - 20 = 85 students study at least one course.",
                "Line 5: Students studying neither = |U| - |A ∪ B| = 100 - 85 = 15."
            ),
            stepByStepSolution = listOf(
                "Step 1: State the Principle: For any two finite sets A and B, |A ∪ B| = |A| + |B| - |A ∩ B|.",
                "Step 2: Proof using disjoint sets: A ∪ B can be partitioned into three disjoint sets: (A - B), (B - A), and (A ∩ B).",
                "Step 3: |A ∪ B| = |A - B| + |B - A| + |A ∩ B|.",
                "Step 4: Since |A| = |A - B| + |A ∩ B| and |B| = |B - A| + |A ∩ B|, substituting yields |A ∪ B| = |A| + |B| - |A ∩ B|.",
                "Step 5: Apply to problem: Given |U| = 100, |A| = 60, |B| = 45, |A ∩ B| = 20.",
                "Step 6: Compute |A ∪ B| = 60 + 45 - 20 = 85.",
                "Step 7: Compute students taking neither = |U| - |A ∪ B| = 100 - 85 = 15."
            ),
            whyStepUsed = listOf(
                "Step 2 partitions A ∪ B into mutually disjoint components so cardinalities can be added directly.",
                "Step 6 uses the proved formula.",
                "Step 7 applies De Morgan's complement rule: |(A ∪ B)'| = |U| - |A ∪ B|."
            ),
            easyExample = "A = {1, 2}, B = {2, 3}. |A|=2, |B|=2, |A ∩ B|=1. |A ∪ B| = 2 + 2 - 1 = 3.",
            examStyleExample = "State the theorem clearly, show the 2-circle Venn diagram, write the algebraic identity, then solve the numerical part step-by-step.",
            twoMarkAnswer = "Principle of Inclusion-Exclusion for two sets:\n|A ∪ B| = |A| + |B| - |A ∩ B|.\nNumerical: |A ∪ B| = 60 + 45 - 20 = 85. Neither = 100 - 85 = 15 students.",
            fiveMarkAnswer = "1. Statement:\nFor two finite sets A and B: |A ∪ B| = |A| + |B| - |A ∩ B|.\n\n2. Proof:\nA ∪ B is partitioned into three disjoint sets:\n|A ∪ B| = |A - B| + |A ∩ B| + |B - A|\nNote that: |A| = |A - B| + |A ∩ B| ⇒ |A - B| = |A| - |A ∩ B|\nand |B| = |B - A| + |A ∩ B| ⇒ |B - A| = |B| - |A ∩ B|\nSubstituting:\n|A ∪ B| = (|A| - |A ∩ B|) + |A ∩ B| + (|B| - |A ∩ B|)\n= |A| + |B| - |A ∩ B| (Hence Proved).\n\n3. Problem Solution:\nTotal students |U| = 100\n|DMGT| = 60, |Java| = 45, |DMGT ∩ Java| = 20\n|DMGT ∪ Java| = 60 + 45 - 20 = 85\nNeither = |U| - |DMGT ∪ Java| = 100 - 85 = 15 students.",
            tenMarkAnswer = "Detailed Principle of Inclusion-Exclusion Analysis with Proof & Numerical Application:\n\n1. Theorem Statement:\nLet A and B be finite sets. The cardinality of the union is the sum of individual cardinalities minus the cardinality of their intersection: |A ∪ B| = |A| + |B| - |A ∩ B|.\n\n2. Formal Set-Theoretic Proof:\nConsider the characteristic function or disjoint partitions:\nA ∪ B = (A \\ B) ∪ (A ∩ B) ∪ (B \\ A)\nSince (A \\ B), (A ∩ B), and (B \\ A) are pairwise disjoint:\n|A ∪ B| = |A \\ B| + |A ∩ B| + |B \\ A|\nBy definition of set difference:\n|A \\ B| = |A| - |A ∩ B|\n|B \\ A| = |B| - |A ∩ B|\nSubstituting these values:\n|A ∪ B| = (|A| - |A ∩ B|) + |A ∩ B| + (|B| - |A ∩ B|)\n|A ∪ B| = |A| + |B| - |A ∩ B|.\n\n3. Extension to Three Sets (For Reference):\n|A ∪ B ∪ C| = |A| + |B| + |C| - (|A ∩ B| + |B ∩ C| + |C ∩ A|) + |A ∩ B ∩ C|.\n\n4. Numerical Application:\nGiven Data:\n- Universal Set |U| = 100\n- Let D = Set of students studying Discrete Mathematics (|D| = 60)\n- Let J = Set of students studying Java (|J| = 45)\n- Both |D ∩ J| = 20\n\nCalculations:\nStudents studying at least one subject:\n|D ∪ J| = |D| + |J| - |D ∩ J| = 60 + 45 - 20 = 85.\n\nStudents studying neither subject:\n|(D ∪ J)'| = |U| - |D ∪ J| = 100 - 85 = 15.\n\nFinal Answer: 15 students study neither subject.",
            commonMistakes = listOf(
                "Adding 60 + 45 = 105 and subtracting 100 directly without using the union formula.",
                "Forgetting to subtract the intersection when computing |A ∪ B|."
            ),
            finalAnswer = "15 students study neither subject.",
            shortcutTip = "Neither = Total - (A + B - Both) = 100 - (60 + 45 - 20) = 15.",
            similarPracticeQuestion = "In a group of 80 people, 50 like coffee, 35 like tea, and 15 like both. How many like neither?"
        ),
        DmgtQuestion(
            id = "q_u2_02",
            unitNumber = 2,
            unitTitle = "Set Theory",
            sourceRef = "R23 Question Bank - Unit II, Q5 (10-Marks)",
            questionText = "Define Partial Order Relation and POSET. Let D_24 = {1, 2, 3, 4, 6, 8, 12, 24} be the divisors of 24 ordered by divisibility. Draw the Hasse diagram and find: (i) Maximal & Minimal elements, (ii) Greatest & Least elements, (iii) GLB and LUB of {4, 6}.",
            marks = 10,
            questionType = "10-Mark",
            difficulty = "Hard",
            topic = "Partial Ordering & Hasse Diagrams",
            simpleDefinition = "A relation R on set A is a Partial Order if it is Reflexive, Anti-symmetric, and Transitive. The pair (A, R) is called a POSET (Partially Ordered Set). A Hasse diagram represents a POSET visually by omitting reflexive loops and transitive edges.",
            formula = "R is Partial Order ⇔ Reflexive ∧ Anti-symmetric ∧ Transitive",
            symbolMeanings = listOf(
                "D_24" to "Set of all positive divisors of 24",
                "a | b" to "Divisibility relation: 'a divides b' with remainder 0",
                "LUB (Join ∨)" to "Least Upper Bound (Supremum) = smallest element ≥ both",
                "GLB (Meet ∧)" to "Greatest Lower Bound (Infimum) = largest element ≤ both",
                "Maximal" to "An element x such that no element y exists with x < y",
                "Minimal" to "An element x such that no element y exists with y < x"
            ),
            lineByLineExplanation = listOf(
                "Line 1: Divisors of 24 are 1, 2, 3, 4, 6, 8, 12, 24 (total 8 elements).",
                "Line 2: Divisibility is Reflexive (a|a), Anti-symmetric (a|b and b|a ⇒ a=b), Transitive (a|b and b|c ⇒ a|c). Hence (D_24, |) is a POSET.",
                "Line 3: Level 0 (bottom): 1 (divides everything).",
                "Line 4: Level 1: Prime factors {2, 3} (1 connects to 2 and 3).",
                "Line 5: Level 2: {4, 6} (2 connects to 4; 2 and 3 connect to 6).",
                "Line 6: Level 3: {8, 12} (4 connects to 8; 4 and 6 connect to 12).",
                "Line 7: Level 4 (top): {24} (8 and 12 connect to 24).",
                "Line 8: For {4, 6}: common divisors (lower bounds) are {1, 2}; the greatest is 2 (GLB = 2). Common multiples (upper bounds) are {12, 24}; the least is 12 (LUB = 12)."
            ),
            stepByStepSolution = listOf(
                "Step 1: Define POSET: A relation R on set S is a partial ordering if it satisfies: (a) Reflexivity: a R a for all a ∈ S, (b) Anti-symmetry: a R b and b R a ⇒ a = b, (c) Transitivity: a R b and b R c ⇒ a R c. The pair (S, R) is a POSET.",
                "Step 2: List elements of D_24: {1, 2, 3, 4, 6, 8, 12, 24}.",
                "Step 3: Construct Hasse Diagram levels:\n- Bottom: 1\n- Level 1: 2, 3 (edges 1-2, 1-3)\n- Level 2: 4, 6 (edges 2-4, 2-6, 3-6)\n- Level 3: 8, 12 (edges 4-8, 4-12, 6-12)\n- Top: 24 (edges 8-24, 12-24).",
                "Step 4: Identify Maximal and Minimal elements:\n- Maximal element: 24 (no element is strictly greater)\n- Minimal element: 1 (no element is strictly smaller).",
                "Step 5: Identify Greatest and Least elements:\n- Greatest element: 24 (every element divides 24)\n- Least element: 1 (1 divides every element).",
                "Step 6: Compute GLB and LUB of {4, 6}:\n- Lower bounds of {4, 6} = common divisors of 4 and 6 = {1, 2}. Greatest is 2. GLB(4, 6) = 2 (gcd).\n- Upper bounds of {4, 6} = common multiples in D_24 = {12, 24}. Least is 12. LUB(4, 6) = 12 (lcm)."
            ),
            whyStepUsed = listOf(
                "Step 1 verifies the 3 required mathematical properties for POSET.",
                "Step 3 removes transitive and reflexive lines according to Hasse diagram conventions.",
                "Step 6 connects GLB and LUB to standard number-theoretic gcd and lcm."
            ),
            easyExample = "For D_6 = {1, 2, 3, 6}: 1 at bottom, 2 and 3 in middle, 6 at top. GLB(2,3) = 1, LUB(2,3) = 6.",
            examStyleExample = "Draw the diamond/cube structure of D_24, label all 8 vertices, write each of (i), (ii), and (iii) with clear headings.",
            twoMarkAnswer = "POSET: A set with a relation that is Reflexive, Anti-symmetric, and Transitive. For (D_24, |):\n- Maximal & Greatest = 24\n- Minimal & Least = 1\n- GLB(4, 6) = gcd(4, 6) = 2\n- LUB(4, 6) = lcm(4, 6) = 12.",
            fiveMarkAnswer = "1. Definitions:\n- Partial Order: Reflexive, Anti-symmetric, Transitive relation.\n- POSET: A pair (S, ≤) where ≤ is a partial order.\n\n2. Divisors of 24: D_24 = {1, 2, 3, 4, 6, 8, 12, 24}\nHasse Diagram Edges (Immediate predecessors):\n(1,2), (1,3), (2,4), (2,6), (3,6), (4,8), (4,12), (6,12), (8,24), (12,24).\n\n3. Answers:\n(i) Maximal: 24, Minimal: 1\n(ii) Greatest: 24, Least: 1\n(iii) Lower bounds of {4,6} = {1,2} ⇒ GLB = 2\nUpper bounds of {4,6} = {12,24} ⇒ LUB = 12.",
            tenMarkAnswer = "Full Exam 10-Mark Answer:\n\n1. Theory of Partial Order & Hasse Diagram:\n- Partial Order Relation: A binary relation R on set A is a partial order iff:\n  1. ∀ a ∈ A: a R a (Reflexive)\n  2. ∀ a,b ∈ A: (a R b ∧ b R a) ⇒ a = b (Anti-symmetric)\n  3. ∀ a,b,c ∈ A: (a R b ∧ b R c) ⇒ a R c (Transitive)\n- Hasse Diagram: A simplified digraph of a finite POSET where:\n  - All self-loops (reflexivity) are deleted.\n  - All transitive edges are deleted.\n  - Direction is implied upward (x ≤ y means y is drawn above x and connected).\n\n2. Analysis of POSET (D_24, |):\nElements = {1, 2, 3, 4, 6, 8, 12, 24}\nCovering Relations (y covers x if x < y and no z exists with x < z < y):\n- 1 is covered by: 2, 3\n- 2 is covered by: 4, 6\n- 3 is covered by: 6\n- 4 is covered by: 8, 12\n- 6 is covered by: 12\n- 8 is covered by: 24\n- 12 is covered by: 24\n\n3. Level-by-Level Graph Construction:\n          [24]\n         /    \\\n       [8]    [12]\n        |    /    \\\n       [4]  /     [6]\n        |  /     /   \\\n       [2]      /     [3]\n         \\     /     /\n          \\   /     /\n             [1]\n\n4. Evaluation of POSET Properties:\n(i) Maximal & Minimal Elements:\n- Maximal element: 24 (no element strictly dominates it)\n- Minimal element: 1 (no element strictly precedes it)\n\n(ii) Greatest & Least Elements:\n- Greatest element: 24 (since x | 24 for all x ∈ D_24)\n- Least element: 1 (since 1 | x for all x ∈ D_24)\n\n(iii) Bounds for Subset S = {4, 6}:\n- Lower bounds: Elements d such that d|4 and d|6 ⇒ common divisors = {1, 2}\n  GLB({4, 6}) = max{1, 2} = 2 (which is gcd(4, 6)).\n- Upper bounds: Elements m such that 4|m and 6|m in D_24 ⇒ common multiples = {12, 24}\n  LUB({4, 6}) = min{12, 24} = 12 (which is lcm(4, 6)).\n\n5. Lattice Property:\nSince every pair of elements in D_24 has a unique GLB (gcd) and LUB (lcm), (D_24, |) is a Lattice.",
            commonMistakes = listOf(
                "Drawing transitive lines (e.g. connecting 1 directly to 24 or 1 to 4).",
                "Confusing GLB (meet) with LUB (join)."
            ),
            finalAnswer = "Maximal/Greatest = 24, Minimal/Least = 1, GLB(4,6) = 2, LUB(4,6) = 12.",
            shortcutTip = "Under divisibility: GLB = gcd(a, b) and LUB = lcm(a, b)!",
            similarPracticeQuestion = "Draw the Hasse diagram for D_30 = {1, 2, 3, 5, 6, 10, 15, 30} and find GLB and LUB of {6, 10}."
        ),
        // UNIT 3: Combinatorics & Recurrence
        DmgtQuestion(
            id = "q_u3_01",
            unitNumber = 3,
            unitTitle = "Combinatorics & Recurrence",
            sourceRef = "R23 Question Bank - Unit III, Q3 (10-Marks)",
            questionText = "Solve the recurrence relation a_n - 7a_{n-1} + 10a_{n-2} = 0 for n ≥ 2, given the initial conditions a_0 = 1, a_1 = 8.",
            marks = 10,
            questionType = "10-Mark",
            difficulty = "Medium",
            topic = "Solving Recurrence: Characteristic Roots",
            simpleDefinition = "A second-order linear homogeneous recurrence relation with constant coefficients is solved by finding the roots of its characteristic polynomial and using initial conditions to determine arbitrary constants.",
            formula = "Characteristic Equation: r^2 - 7r + 10 = 0 ⇒ General Solution: a_n = c_1 (r_1)^n + c_2 (r_2)^n",
            symbolMeanings = listOf(
                "a_n" to "The n-th term of the sequence",
                "a_{n-1}, a_{n-2}" to "Previous two terms of the sequence",
                "r" to "Characteristic root of the auxiliary equation",
                "c_1, c_2" to "Arbitrary constants solved using initial conditions a_0 and a_1",
                "n" to "Non-negative integer index (n = 0, 1, 2, ...)"
            ),
            lineByLineExplanation = listOf(
                "Line 1: Given homogeneous relation: a_n - 7a_{n-1} + 10a_{n-2} = 0.",
                "Line 2: Substitute trial solution a_n = r^n: r^n - 7r^{n-1} + 10r^{n-2} = 0.",
                "Line 3: Divide by r^{n-2} to get characteristic equation: r^2 - 7r + 10 = 0.",
                "Line 4: Factorize: (r - 2)(r - 5) = 0, giving distinct real roots r_1 = 2, r_2 = 5.",
                "Line 5: Form the general solution: a_n = c_1 (2)^n + c_2 (5)^n.",
                "Line 6: Apply initial condition a_0 = 1: c_1 (2)^0 + c_2 (5)^0 = 1 ⇒ c_1 + c_2 = 1.",
                "Line 7: Apply initial condition a_1 = 8: c_1 (2)^1 + c_2 (5)^1 = 8 ⇒ 2c_1 + 5c_2 = 8.",
                "Line 8: Solve system: From (6), c_1 = 1 - c_2. Substitute in (7): 2(1 - c_2) + 5c_2 = 8 ⇒ 2 + 3c_2 = 8 ⇒ 3c_2 = 6 ⇒ c_2 = 2.",
                "Line 9: Then c_1 = 1 - 2 = -1.",
                "Line 10: Final explicit formula: a_n = -(2)^n + 2(5)^n."
            ),
            stepByStepSolution = listOf(
                "Step 1: Write down the recurrence relation: a_n - 7a_{n-1} + 10a_{n-2} = 0.",
                "Step 2: Form the characteristic equation by replacing a_n by r^2, a_{n-1} by r, and a_{n-2} by 1: r^2 - 7r + 10 = 0.",
                "Step 3: Solve the quadratic equation:\n(r - 2)(r - 5) = 0\nRoots are r_1 = 2, r_2 = 5 (real and distinct).",
                "Step 4: Write the general solution for distinct roots:\na_n = c_1 (2)^n + c_2 (5)^n.",
                "Step 5: Use initial conditions to solve for c_1 and c_2:\nFor n = 0: a_0 = c_1 + c_2 = 1  --- (Equation 1)\nFor n = 1: a_1 = 2c_1 + 5c_2 = 8 --- (Equation 2).",
                "Step 6: Multiply Eq 1 by 2: 2c_1 + 2c_2 = 2.\nSubtract from Eq 2: 3c_2 = 6 ⇒ c_2 = 2.",
                "Step 7: Substitute c_2 = 2 into Eq 1: c_1 + 2 = 1 ⇒ c_1 = -1.",
                "Step 8: Substitute c_1 and c_2 back into the general solution:\na_n = -1 · 2^n + 2 · 5^n = 2 · 5^n - 2^n."
            ),
            whyStepUsed = listOf(
                "Step 2 transforms the recurrence into an algebraic polynomial whose roots govern the exponential growth rates.",
                "Step 4 uses the linear independence of solutions corresponding to distinct roots.",
                "Step 5 and 6 apply boundary conditions to find the unique particular sequence."
            ),
            easyExample = "a_n - 3a_{n-1} = 0, a_0 = 4. Characteristic root r = 3 ⇒ a_n = 4 · 3^n.",
            examStyleExample = "Verification: For n=2, formula gives a_2 = 2(25) - 4 = 46. From recurrence: a_2 = 7(8) - 10(1) = 56 - 10 = 46. Matches perfectly!",
            twoMarkAnswer = "Recurrence: a_n - 7a_{n-1} + 10a_{n-2} = 0.\nCharacteristic equation: r^2 - 7r + 10 = 0 ⇒ r = 2, 5.\nGeneral solution: a_n = c_1 2^n + c_2 5^n.\nUsing a_0 = 1, a_1 = 8 ⇒ c_1 = -1, c_2 = 2.\nFinal Answer: a_n = 2(5)^n - 2^n.",
            fiveMarkAnswer = "1. Characteristic Equation:\nr^2 - 7r + 10 = 0\n(r - 2)(r - 5) = 0 ⇒ r_1 = 2, r_2 = 5.\n\n2. General Solution:\na_n = c_1 (2)^n + c_2 (5)^n\n\n3. Initial Conditions:\na_0 = 1 ⇒ c_1 + c_2 = 1\na_1 = 8 ⇒ 2c_1 + 5c_2 = 8\n\n4. Solving Constants:\n2(c_1 + c_2) = 2\n(2c_1 + 5c_2) - (2c_1 + 2c_2) = 8 - 2\n3c_2 = 6 ⇒ c_2 = 2\nc_1 = 1 - 2 = -1\n\n5. Final Solution:\na_n = 2 · 5^n - 2^n for n ≥ 0.",
            tenMarkAnswer = "Comprehensive 10-Mark Solution:\n\n1. Classification of the Recurrence Relation:\nThe equation a_n - 7a_{n-1} + 10a_{n-2} = 0 is a Linear Homogeneous Recurrence Relation of order 2 with constant coefficients.\n\n2. Derivation of Characteristic Equation:\nAssume a non-trivial solution of the form a_n = r^n (r ≠ 0).\nSubstituting into the recurrence relation:\nr^n - 7r^{n-1} + 10r^{n-2} = 0\nDividing throughout by r^{n-2}:\nr^2 - 7r + 10 = 0\n\n3. Determination of Characteristic Roots:\nFactoring the quadratic equation:\n(r - 2)(r - 5) = 0\nRoots: r_1 = 2, r_2 = 5.\nSince the roots are real and distinct, the two basic solutions 2^n and 5^n are linearly independent.\n\n4. General Solution Construction:\na_n = c_1 (2)^n + c_2 (5)^n, where c_1, c_2 are arbitrary constants.\n\n5. Boundary Conditions & Systems of Linear Equations:\nGiven initial conditions:\na_0 = 1\na_1 = 8\n\nSetting n = 0:\na_0 = c_1 (2)^0 + c_2 (5)^0 = 1\n⇒ c_1 + c_2 = 1  -------------------- (Eq. 1)\n\nSetting n = 1:\na_1 = c_1 (2)^1 + c_2 (5)^1 = 8\n⇒ 2c_1 + 5c_2 = 8 -------------------- (Eq. 2)\n\nFrom Eq. 1: c_1 = 1 - c_2\nSubstitute in Eq. 2:\n2(1 - c_2) + 5c_2 = 8\n2 - 2c_2 + 5c_2 = 8\n3c_2 = 6\n⇒ c_2 = 2\n\nSubstitute c_2 = 2 in Eq. 1:\nc_1 + 2 = 1\n⇒ c_1 = -1\n\n6. Final Explicit Solution:\na_n = (-1) · 2^n + (2) · 5^n\n∴ a_n = 2 · 5^n - 2^n for all n ≥ 0.\n\n7. Step-by-Step Verification:\n- For n = 0: a_0 = 2(1) - 1 = 1 (Verified)\n- For n = 1: a_1 = 2(5) - 2 = 8 (Verified)\n- For n = 2: a_2 = 2(25) - 4 = 46.\n  From recurrence: a_2 = 7(8) - 10(1) = 56 - 10 = 46 (Verified).",
            commonMistakes = listOf(
                "Assuming repeated root formula c_1 + c_2 n when roots are distinct.",
                "Arithmetic errors when solving the simultaneous equations for c_1 and c_2."
            ),
            finalAnswer = "a_n = 2(5)^n - 2^n",
            shortcutTip = "For r^2 - Sr + P = 0, sum of roots S = 7, product P = 10, immediately gives r = 2, 5!",
            similarPracticeQuestion = "Solve a_n - 5a_{n-1} + 6a_{n-2} = 0 with a_0 = 2, a_1 = 5."
        ),
        // UNIT 4: Graph Theory
        DmgtQuestion(
            id = "q_u4_01",
            unitNumber = 4,
            unitTitle = "Graph Theory",
            sourceRef = "R23 Question Bank - Unit IV, Q1 (2-Marks & 5-Marks)",
            questionText = "State and prove the Handshaking Theorem. Show that in any graph, the number of vertices of odd degree is always even.",
            marks = 5,
            questionType = "5-Mark",
            difficulty = "Easy",
            topic = "Basic Graph Concepts & Handshaking",
            simpleDefinition = "The Handshaking Theorem states that the sum of degrees of all vertices in an undirected graph equals twice the number of edges. Consequently, the number of odd-degree vertices must be even.",
            formula = "∑_{v ∈ V} deg(v) = 2|E|",
            symbolMeanings = listOf(
                "V" to "Set of vertices in graph G",
                "E" to "Set of edges in graph G",
                "deg(v)" to "Degree of vertex v (number of edges incident with v, loops count twice)",
                "|E|" to "Total number of edges in G",
                "V_odd" to "Set of vertices with odd degree",
                "V_even" to "Set of vertices with even degree"
            ),
            lineByLineExplanation = listOf(
                "Line 1: Every edge e = (u, v) connects two vertices u and v.",
                "Line 2: Therefore, when computing the degree of every vertex, each edge contributes 1 to the degree of u and 1 to the degree of v.",
                "Line 3: That means each edge is counted exactly twice in the sum of degrees.",
                "Line 4: Thus, ∑ deg(v) = 2|E|, which is an even integer.",
                "Line 5: Partition V into V_odd and V_even: ∑_{v ∈ V_odd} deg(v) + ∑_{v ∈ V_even} deg(v) = 2|E|.",
                "Line 6: Since 2|E| is even and ∑ deg(v) for even vertices is even, ∑_{v ∈ V_odd} deg(v) must be even.",
                "Line 7: A sum of odd numbers is even if and only if the number of terms is even. Hence |V_odd| is even."
            ),
            stepByStepSolution = listOf(
                "Step 1: Statement: In any undirected graph G = (V, E), the sum of the degrees of all vertices is equal to twice the number of edges: ∑_{v ∈ V} deg(v) = 2|E|.",
                "Step 2: Proof: Let e = (u, v) be an edge in G. Edge e contributes 1 to deg(u) and 1 to deg(v). If e is a loop, it contributes 2 to the degree of that vertex. Hence, every edge contributes exactly 2 to the total degree sum. Therefore, ∑ deg(v) = 2|E|.",
                "Step 3: Corollary Statement: In any graph, the number of vertices of odd degree is even.",
                "Step 4: Proof: Let V_1 be the set of odd degree vertices and V_2 be the set of even degree vertices. Then V = V_1 ∪ V_2 and V_1 ∩ V_2 = ∅.",
                "Step 5: ∑_{v ∈ V} deg(v) = ∑_{v ∈ V_1} deg(v) + ∑_{v ∈ V_2} deg(v) = 2|E|.",
                "Step 6: ∑_{v ∈ V_1} deg(v) = 2|E| - ∑_{v ∈ V_2} deg(v).",
                "Step 7: 2|E| is even, and the sum of even numbers is even. Therefore, the right-hand side is even.",
                "Step 8: The left-hand side is a sum of odd integers. A sum of odd integers can be even only if the number of odd integers is EVEN. Hence, |V_1| is even."
            ),
            whyStepUsed = listOf(
                "Step 2 uses double counting on the incidence relation between vertices and edges.",
                "Step 4 partitions the vertices into mutually exclusive parity classes.",
                "Step 8 uses basic number theory parity rule (odd × even = even)."
            ),
            easyExample = "In K3 (triangle): 3 vertices each of degree 2. Sum = 2 + 2 + 2 = 6 = 2(3 edges). Zero odd vertices (0 is even).",
            examStyleExample = "Can a graph have 5 vertices of degree 3 and 2 vertices of degree 4? Answer: Sum of degrees = 5(3) + 2(4) = 23 (odd, impossible by Handshaking Theorem!).",
            twoMarkAnswer = "Handshaking Theorem: In any undirected graph, the sum of degrees of all vertices is twice the number of edges: ∑ deg(v) = 2|E|.\nCorollary: The number of vertices of odd degree is always even.",
            fiveMarkAnswer = "1. Handshaking Theorem Statement:\nFor any graph G = (V, E), ∑_{v ∈ V} deg(v) = 2|E|.\n\n2. Proof:\nEach edge has two end vertices, contributing 1 to the degree of each end vertex. A loop contributes 2 to the vertex. Thus each edge contributes 2 to the total sum of degrees.\n∴ ∑ deg(v) = 2|E| (Hence Proved).\n\n3. Odd Degree Vertices Corollary:\nPartition V into V_odd (odd degree) and V_even (even degree):\n∑_{v ∈ V_odd} deg(v) + ∑_{v ∈ V_even} deg(v) = 2|E|\n∑_{v ∈ V_odd} deg(v) = 2|E| - (even number) = even number.\nSince the sum of odd numbers is even, the number of odd vertices |V_odd| must be EVEN.",
            tenMarkAnswer = "Complete 10-Mark Academic Proof & Problem Suite:\n\n1. Formal Theorem Statement:\nLet G = (V, E) be an undirected graph with vertex set V and edge set E. Then the sum of the degrees of the vertices equals twice the number of edges:\n∑_{v ∈ V} deg(v) = 2|E|\n\n2. Proof of Handshaking Theorem:\nLet the incidence matrix of G be M = [m_ij], where:\nm_ij = 1 if vertex v_i is incident with edge e_j, and 0 otherwise.\n- The sum of entries in row i is the degree of vertex v_i: ∑_j m_ij = deg(v_i).\n- The sum of entries in column j is 2, because edge e_j has exactly two endpoints: ∑_i m_ij = 2.\nSumming all entries in M row-wise and column-wise:\nTotal = ∑_i (∑_j m_ij) = ∑_{v_i ∈ V} deg(v_i)\nTotal = ∑_j (∑_i m_ij) = ∑_{e_j ∈ E} 2 = 2|E|\nTherefore, ∑_{v ∈ V} deg(v) = 2|E|.\n\n3. Proof that Odd Degree Vertices are Even in Number:\nLet V be partitioned into two disjoint subsets:\n- V_1 = {v ∈ V | deg(v) is odd}\n- V_2 = {v ∈ V | deg(v) is even}\nClearly V = V_1 ∪ V_2 and V_1 ∩ V_2 = ∅.\nBy Handshaking Theorem:\n∑_{v ∈ V_1} deg(v) + ∑_{v ∈ V_2} deg(v) = 2|E|\n⇒ ∑_{v ∈ V_1} deg(v) = 2|E| - ∑_{v ∈ V_2} deg(v)\nSince 2|E| is even and each deg(v) for v ∈ V_2 is even, the RHS is even.\nTherefore, ∑_{v ∈ V_1} deg(v) is an even integer.\nSince every term in the sum is an odd integer, an odd integer added an odd number of times yields an odd sum, while added an even number of times yields an even sum.\nTherefore, the number of elements in V_1 must be EVEN.\n\n4. Typical R23 Exam Applications:\n(a) Question: Can a simple graph have 15 vertices each of degree 5?\nSolution: Sum of degrees = 15 × 5 = 75 (odd). By Handshaking theorem, sum must be 2|E| (even). 75 is not even, so NO such graph exists.\n(b) Question: A graph has 4 vertices of degree 2, 3 vertices of degree 3, and 2 vertices of degree 4. How many edges does it have?\nSolution: Sum = (4×2) + (3×3) + (2×4) = 8 + 9 + 8 = 25. 25 is odd, so such a graph is impossible!",
            commonMistakes = listOf(
                "Forgetting that loops count 2 towards the vertex degree.",
                "Thinking that the degree sum must be odd for odd graphs (degree sum is ALWAYS even)."
            ),
            finalAnswer = "∑ deg(v) = 2|E|, and |V_odd| is always even.",
            shortcutTip = "Any problem giving degrees: sum them up. If the sum is odd, immediately answer 'Impossible'!",
            similarPracticeQuestion = "A graph G has 21 edges, 3 vertices of degree 4, and all other vertices of degree 3. Find the total number of vertices."
        ),
        // UNIT 5: Multigraphs, Planarity & Trees
        DmgtQuestion(
            id = "q_u5_01",
            unitNumber = 5,
            unitTitle = "Multi Graphs & Trees",
            sourceRef = "R23 Question Bank - Unit V, Q2 (10-Marks)",
            questionText = "State Euler's formula for connected planar graphs. Prove that for any simple connected planar graph with V ≥ 3 vertices and E edges, E ≤ 3V - 6. Hence show that K_5 is non-planar.",
            marks = 10,
            questionType = "10-Mark",
            difficulty = "Hard",
            topic = "Planar Graphs & Euler's Formula",
            simpleDefinition = "Euler's formula states that for any connected planar graph drawn without edge crossings, V - E + R = 2 (where V = vertices, E = edges, R = regions/faces).",
            formula = "Euler's Formula: V - E + R = 2, Planarity Bound: E ≤ 3V - 6",
            symbolMeanings = listOf(
                "V" to "Number of vertices in the planar graph",
                "E" to "Number of edges",
                "R" to "Number of regions (faces) including the unbounded outer face",
                "deg(r)" to "Degree of a region r (number of bounding edges)",
                "K_5" to "Complete graph on 5 vertices (each vertex connected to all 4 others)"
            ),
            lineByLineExplanation = listOf(
                "Line 1: A planar graph can be embedded in the plane such that no two edges intersect except at vertices.",
                "Line 2: Each region r in a simple graph is bounded by at least 3 edges: deg(r) ≥ 3.",
                "Line 3: Every edge bounds at most 2 regions (or one region twice): ∑_{r} deg(r) = 2E.",
                "Line 4: Therefore, 2E = ∑ deg(r) ≥ 3R ⇒ R ≤ 2E / 3.",
                "Line 5: From Euler's formula: R = 2 - V + E.",
                "Line 6: Substitute R: 2 - V + E ≤ 2E / 3 ⇒ 6 - 3V + 3E ≤ 2E ⇒ E ≤ 3V - 6.",
                "Line 7: For K_5: V = 5, E = 5(4)/2 = 10.",
                "Line 8: Maximum possible edges for planarity = 3(5) - 6 = 15 - 6 = 9.",
                "Line 9: But K_5 has 10 edges > 9, violating the necessary condition. Therefore K_5 is non-planar."
            ),
            stepByStepSolution = listOf(
                "Step 1: State Euler's Formula: If G is a connected planar graph with V vertices, E edges, and R regions, then V - E + R = 2.",
                "Step 2: Proof of E ≤ 3V - 6:\nIn a simple connected planar graph with V ≥ 3, every region is bounded by at least 3 edges. That is, for every region r, deg(r) ≥ 3.",
                "Step 3: Summing the boundary edges over all regions gives: ∑_{i=1}^R deg(r_i) = 2E.",
                "Step 4: Since deg(r_i) ≥ 3 for each of the R regions: 2E = ∑ deg(r_i) ≥ 3R ⇒ R ≤ 2E / 3.",
                "Step 5: Substitute into Euler's formula V - E + R = 2:\nR = 2 - V + E ≤ 2E / 3.",
                "Step 6: Multiply by 3:\n3(2 - V + E) ≤ 2E\n6 - 3V + 3E ≤ 2E\nE ≤ 3V - 6 (Hence Proved).",
                "Step 7: Non-planarity of K_5:\nFor complete graph K_5:\nV = 5\nNumber of edges E = C(5, 2) = 10.",
                "Step 8: If K_5 were planar, it must satisfy E ≤ 3V - 6.\n3(5) - 6 = 15 - 6 = 9.\nSince E = 10 > 9, K_5 violates the condition.\nTherefore, K_5 is non-planar."
            ),
            whyStepUsed = listOf(
                "Step 2 notes that in a simple graph there are no loops (length 1) or parallel edges (length 2), so the smallest face cycle has length ≥ 3.",
                "Step 3 uses the face-edge handshaking relation.",
                "Step 7 applies this necessary planarity bound directly to K_5."
            ),
            easyExample = "For K4: V = 4, E = 6. 3V - 6 = 3(4) - 6 = 6. E ≤ 6 holds, and K4 is planar (can be drawn as triangle with center vertex).",
            examStyleExample = "State Euler's formula, write the edge-region summation 2E ≥ 3R clearly, derive E ≤ 3V - 6, calculate K5 values, and conclude.",
            twoMarkAnswer = "Euler's Formula: V - E + R = 2 for connected planar graphs.\nFor simple planar graph: E ≤ 3V - 6.\nFor K_5: V=5, E=10. Max allowed E = 3(5)-6 = 9. Since 10 > 9, K_5 is non-planar.",
            fiveMarkAnswer = "1. Euler's Formula: V - E + R = 2\n\n2. Proof of E ≤ 3V - 6:\nIn any simple planar graph with V ≥ 3, every region is bounded by at least 3 edges:\n2E = ∑ deg(r) ≥ 3R ⇒ R ≤ 2E/3.\nFrom Euler's formula, R = 2 - V + E.\n2 - V + E ≤ 2E/3\n6 - 3V + 3E ≤ 2E\nE ≤ 3V - 6.\n\n3. Non-planarity of K_5:\nFor K_5: V = 5, E = 5×4/2 = 10.\nE ≤ 3(5) - 6 = 9.\nHere E = 10 > 9, so K_5 cannot be planar.",
            tenMarkAnswer = "Comprehensive 10-Mark Solution:\n\n1. Planar Graph Foundations:\n- Planar Graph: A graph G is planar if it can be drawn in a plane such that its edges intersect only at their common vertices.\n- Regions/Faces: The edges divide the plane into contiguous areas called regions. Exactly one region is unbounded (exterior face).\n\n2. Euler's Formula Statement:\nFor any connected planar graph with V vertices, E edges, and R regions:\nV - E + R = 2\n\n3. Mathematical Proof of Bound E ≤ 3V - 6:\nLet G be a simple connected planar graph with V ≥ 3.\n- In a simple graph, there are no self-loops and no multi-edges.\n- Consequently, the boundary of each region must contain at least 3 edges.\n  deg(r_i) ≥ 3 for all i = 1, 2, ..., R.\n- Each edge serves as a boundary between two regions, or lies entirely within one region (counted twice).\n  ∑_{i=1}^R deg(r_i) = 2E\n- Combining inequalities:\n  2E = ∑_{i=1}^R deg(r_i) ≥ 3R\n  ⇒ R ≤ (2/3) E  ------------------- (Eq. 1)\n\nFrom Euler's formula:\nV - E + R = 2\n⇒ R = 2 + E - V  ------------------- (Eq. 2)\n\nSubstituting Eq. 2 into Eq. 1:\n2 + E - V ≤ (2/3) E\nMultiplying throughout by 3:\n6 + 3E - 3V ≤ 2E\n3E - 2E ≤ 3V - 6\n∴ E ≤ 3V - 6 (Hence Proved).\n\n4. Application to Complete Graph K_5:\n- A complete graph K_n has n vertices and n(n-1)/2 edges.\n- For K_5: V = 5, E = (5 × 4) / 2 = 10.\n- Calculate planarity bound:\n  E_max = 3V - 6 = 3(5) - 6 = 15 - 6 = 9.\n- Comparison: Actual edges E = 10 > 9.\n- Since K_5 violates the necessary condition E ≤ 3V - 6, K_5 is NON-PLANAR.\n\n5. Kuratowski's Theorem Note:\nKuratowski (1930) proved that a graph is planar if and only if it does not contain a subgraph homeomorphic to K_5 or K_{3,3}.",
            commonMistakes = listOf(
                "Writing V + E - R = 2 instead of V - E + R = 2.",
                "Applying E ≤ 3V - 6 to bipartite graphs where girth is 4 (for bipartite graphs the bound is E ≤ 2V - 4)."
            ),
            finalAnswer = "E ≤ 3V - 6. For K_5, E=10 > 9, hence non-planar.",
            shortcutTip = "For K5: 10 edges > 9 max edges. For K3,3: 9 edges > 8 max edges (2V - 4). Both are non-planar!",
            similarPracticeQuestion = "Prove that K_{3,3} (complete bipartite utility graph) is non-planar using Euler's formula and region degree ≥ 4."
        ),
        DmgtQuestion(
            id = "q_u5_02",
            unitNumber = 5,
            unitTitle = "Multi Graphs & Trees",
            sourceRef = "R23 Question Bank - Unit V, Q5 (10-Marks)",
            questionText = "Explain Prim's and Kruskal's algorithms for finding a Minimum Spanning Tree (MST). Trace Kruskal's algorithm on a graph with vertices {A, B, C, D, E} and edges: (A,B)=1, (A,C)=5, (B,C)=4, (B,D)=3, (C,D)=2, (C,E)=6, (D,E)=7.",
            marks = 10,
            questionType = "10-Mark",
            difficulty = "Medium",
            topic = "Minimum Spanning Trees: Kruskal & Prim",
            simpleDefinition = "A Minimum Spanning Tree (MST) of a weighted connected graph connects all vertices with minimum total edge weight. Kruskal's algorithm adds the smallest available edge that doesn't form a cycle. Prim's algorithm grows a single tree by repeatedly adding the cheapest edge to an unvisited vertex.",
            formula = "Total MST edges = |V| - 1 = 5 - 1 = 4 edges",
            symbolMeanings = listOf(
                "V" to "Vertices {A, B, C, D, E} (|V| = 5)",
                "E" to "Edges with weights",
                "MST" to "Minimum Spanning Tree with |V|-1 edges and no cycles",
                "w(e)" to "Weight of edge e"
            ),
            lineByLineExplanation = listOf(
                "Line 1: Given 5 vertices, the MST must have exactly 5 - 1 = 4 edges.",
                "Line 2: Sort all edges in non-decreasing order of weight:",
                "Line 3: (A, B) = 1, (C, D) = 2, (B, D) = 3, (B, C) = 4, (A, C) = 5, (C, E) = 6, (D, E) = 7.",
                "Line 4: Step 1: Add (A, B) wt 1. No cycle. Edges = {(A, B)}.",
                "Line 5: Step 2: Add (C, D) wt 2. No cycle. Edges = {(A, B), (C, D)}.",
                "Line 6: Step 3: Add (B, D) wt 3. No cycle. Connects sets {A, B} and {C, D}. Edges = {(A, B), (C, D), (B, D)}.",
                "Line 7: Step 4: Next is (B, C) wt 4. Checking B-C-D forms a cycle (B-D-C-B)! REJECT (B, C).",
                "Line 8: Step 5: Next is (A, C) wt 5. Forms cycle (A-B-D-C-A)! REJECT (A, C).",
                "Line 9: Step 6: Next is (C, E) wt 6. Connects E to the tree. No cycle! ACCEPT (C, E).",
                "Line 10: We have 4 edges. MST is complete. Total weight = 1 + 2 + 3 + 6 = 12."
            ),
            stepByStepSolution = listOf(
                "Step 1: Prim's Algorithm Concept: Start from any vertex (say A). Maintain a visited set and unvisited set. At each step, select the minimum weight edge connecting a visited vertex to an unvisited vertex. Repeat until all vertices are visited.",
                "Step 2: Kruskal's Algorithm Concept: Sort all edges in ascending order of weights. Repeatedly pick the edge of smallest weight. If including it forms a cycle (checked via Disjoint Sets / Union-Find), discard it. Otherwise, add it to the MST. Stop when (|V| - 1) edges are selected.",
                "Step 3: Execution of Kruskal's on given graph:\nVertices: A, B, C, D, E (|V| = 5 ⇒ MST has 4 edges).\nSorted Edge List:\n1. (A, B) = 1\n2. (C, D) = 2\n3. (B, D) = 3\n4. (B, C) = 4\n5. (A, C) = 5\n6. (C, E) = 6\n7. (D, E) = 7.",
                "Step 4: Edge 1: (A, B), wt = 1 → ACCEPT (Components: {A, B}, {C}, {D}, {E}).",
                "Step 5: Edge 2: (C, D), wt = 2 → ACCEPT (Components: {A, B}, {C, D}, {E}).",
                "Step 6: Edge 3: (B, D), wt = 3 → ACCEPT (Components: {A, B, C, D}, {E}).",
                "Step 7: Edge 4: (B, C), wt = 4 → REJECT (B and C are already in same component {A, B, C, D}, forms cycle B-D-C-B).",
                "Step 8: Edge 5: (A, C), wt = 5 → REJECT (Forms cycle A-B-D-C-A).",
                "Step 9: Edge 6: (C, E), wt = 6 → ACCEPT (Components: {A, B, C, D, E}).",
                "Step 10: Count of selected edges = 4 = |V| - 1. STOP.\nMST Edges: {(A, B), (C, D), (B, D), (C, E)}.\nTotal Weight = 1 + 2 + 3 + 6 = 12."
            ),
            whyStepUsed = listOf(
                "Sorting ensures the greedy choice property.",
                "Rejecting (B,C) and (A,C) is necessary because trees cannot contain cycles.",
                "Stopping at |V|-1 prevents adding redundant edges."
            ),
            easyExample = "Triangle ABC with weights 1, 2, 3. Kruskal picks wt 1 and 2. Wt 3 rejected. MST weight = 3.",
            examStyleExample = "Present the sorted table with columns: Edge, Weight, Cycle? (Yes/No), Decision (Accept/Reject). State final MST edges and total weight clearly.",
            twoMarkAnswer = "Kruskal's: Edge-based greedy MST algorithm. Sorts edges by weight, adds without cycles.\nPrim's: Vertex-based greedy MST algorithm. Grows a single tree from a source vertex.\nTrace result: MST edges {(A,B), (C,D), (B,D), (C,E)}, Total Weight = 12.",
            fiveMarkAnswer = "1. Comparison:\n- Kruskal: Global edge greedy. Uses Union-Find. Time: O(E log E).\n- Prim: Local tree expansion. Uses Priority Queue. Time: O(E log V).\n\n2. Kruskal Trace:\nSorted: (A,B)=1, (C,D)=2, (B,D)=3, (B,C)=4, (A,C)=5, (C,E)=6, (D,E)=7.\n- Pick (A,B)=1: Accept\n- Pick (C,D)=2: Accept\n- Pick (B,D)=3: Accept\n- Pick (B,C)=4: Reject (forms cycle B-C-D)\n- Pick (A,C)=5: Reject (forms cycle)\n- Pick (C,E)=6: Accept\nMST Edges: {(A,B), (C,D), (B,D), (C,E)}\nTotal Weight = 1 + 2 + 3 + 6 = 12.",
            tenMarkAnswer = "Exhaustive 10-Mark Solution:\n\n1. Theory of Minimum Spanning Tree (MST):\n- Given a connected, undirected, weighted graph G = (V, E, w).\n- A Spanning Tree T = (V, E_T) is an acyclic subgraph connecting all |V| vertices with |E_T| = |V| - 1 edges.\n- A Minimum Spanning Tree minimizes the total weight: w(T) = ∑_{e ∈ E_T} w(e).\n\n2. Comparison of Kruskal's vs Prim's Algorithms:\n| Feature | Kruskal's Algorithm | Prim's Algorithm |\n|---|---|---|\n| Approach | Edge-centric greedy | Vertex-centric greedy |\n| Data Structure | Disjoint-set (Union-Find) | Priority queue / Min-heap |\n| Graph type | Best for sparse graphs | Best for dense graphs |\n| Intermediate state | Forest of growing trees | Single growing tree |\n| Time Complexity | O(E log E) or O(E log V) | O(E log V) |\n\n3. Detailed Trace of Kruskal's Algorithm on Given Graph:\nVertices: V = {A, B, C, D, E} (|V| = 5). Target edge count = 5 - 1 = 4.\n\nSorted Edge Table & Cycle Detection:\n| Iteration | Edge (u, v) | Weight | Forms Cycle? | Action | Disjoint Sets Formed |\n|---|---|---|---|---|---|\n| 1 | (A, B) | 1 | No | ACCEPT | {A, B}, {C}, {D}, {E} |\n| 2 | (C, D) | 2 | No | ACCEPT | {A, B}, {C, D}, {E} |\n| 3 | (B, D) | 3 | No | ACCEPT | {A, B, C, D}, {E} |\n| 4 | (B, C) | 4 | Yes (B-D-C-B) | REJECT | {A, B, C, D}, {E} |\n| 5 | (A, C) | 5 | Yes (A-B-D-C-A) | REJECT | {A, B, C, D}, {E} |\n| 6 | (C, E) | 6 | No | ACCEPT | {A, B, C, D, E} |\n\nAt Iteration 6, 4 edges have been selected, which equals |V| - 1.\nThe algorithm terminates immediately.\n\n4. Final MST Structure:\nEdges in MST:\n1. (A, B) with weight 1\n2. (C, D) with weight 2\n3. (B, D) with weight 3\n4. (C, E) with weight 6\n\nTotal Weight of MST = 1 + 2 + 3 + 6 = 12.\n\n5. Verification with Prim's Algorithm (Starting from A):\n- Start A: Available edges = {(A, B): 1, (A, C): 5}. Pick (A, B): 1. Tree = {A, B}.\n- Available = {(B, D): 3, (B, C): 4, (A, C): 5}. Pick (B, D): 3. Tree = {A, B, D}.\n- Available = {(D, C): 2, (D, E): 7, (B, C): 4, (A, C): 5}. Pick (D, C): 2. Tree = {A, B, C, D}.\n- Available = {(C, E): 6, (D, E): 7}. Pick (C, E): 6. Tree = {A, B, C, D, E}.\nTotal Weight = 1 + 3 + 2 + 6 = 12. Both algorithms produce the exact same optimal MST!",
            commonMistakes = listOf(
                "Not stopping when |V|-1 edges are chosen.",
                "Forgetting to sort the edges first in Kruskal's algorithm."
            ),
            finalAnswer = "MST edges = {(A,B), (C,D), (B,D), (C,E)}, Total Weight = 12",
            shortcutTip = "Always count vertices first: if V = 5, your MST will have exactly 4 edges!",
            similarPracticeQuestion = "Find the MST using Prim's algorithm for the same graph starting from vertex C."
        )
    )
}
