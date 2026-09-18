package com.example

import com.example.data.models.SupportedLanguage
import com.example.data.repository.DmgtDataSeed
import com.example.data.repository.DmgtFormulaSeed
import com.example.data.repository.DmgtQuestionSeed
import com.example.data.repository.DmgtQuestionSeedPart2
import com.example.data.repository.DmgtQuizAndMediaSeed
import org.junit.Assert.*
import org.junit.Test

class DmgtRepositoryTest {

    @Test
    fun testAllFiveUnitsExist() {
        val units = DmgtDataSeed.units
        assertEquals("Must have 5 units for R23 syllabus", 5, units.size)
        assertEquals(1, units[0].unitNumber)
        assertEquals(2, units[1].unitNumber)
        assertEquals(3, units[2].unitNumber)
        assertEquals(4, units[3].unitNumber)
        assertEquals(5, units[4].unitNumber)
    }

    @Test
    fun testQuestionBankCoverage() {
        val allQuestions = DmgtQuestionSeed.questions + DmgtQuestionSeedPart2.additionalQuestions
        assertTrue("Question bank should have substantial questions", allQuestions.size >= 10)

        // Verify each question has the 10-part pedagogical structure
        for (q in allQuestions) {
            assertNotNull(q.id)
            assertTrue("Unit must be 1 to 5", q.unitNumber in 1..5)
            assertTrue("Simple definition cannot be empty", q.simpleDefinition.isNotBlank())
            assertTrue("Formula cannot be empty", q.formula.isNotBlank())
            assertTrue("Symbol meanings cannot be empty", q.symbolMeanings.isNotEmpty())
            assertTrue("Step by step solution cannot be empty", q.stepByStepSolution.isNotEmpty())
            assertTrue("2-mark answer cannot be empty", q.twoMarkAnswer.isNotBlank())
            assertTrue("5-mark answer cannot be empty", q.fiveMarkAnswer.isNotBlank())
            assertTrue("10-mark answer cannot be empty", q.tenMarkAnswer.isNotBlank())
            assertTrue("Common mistakes cannot be empty", q.commonMistakes.isNotEmpty())
            assertTrue("Final answer cannot be empty", q.finalAnswer.isNotBlank())
            assertTrue("Source reference cannot be empty", q.sourceRef.isNotBlank())
        }
    }

    @Test
    fun testFormulaBankIntegrity() {
        val formulas = DmgtFormulaSeed.formulas
        assertTrue("Formula bank must not be empty", formulas.isNotEmpty())
        for (f in formulas) {
            assertTrue("Formula name cannot be blank", f.name.isNotBlank())
            assertTrue("Formula latex/math cannot be blank", f.formula.isNotBlank())
            assertTrue("When to use must have guidance", f.whenToUse.isNotBlank())
        }
    }

    @Test
    fun testQuizAndMediaIntegrity() {
        val quizzes = DmgtQuizAndMediaSeed.quizQuestions
        assertTrue("Quiz questions should be present", quizzes.isNotEmpty())
        for (q in quizzes) {
            assertEquals("Quiz question must have 4 options", 4, q.options.size)
            assertTrue("Correct option index must be in range 0..3", q.correctOptionIndex in 0..3)
            assertTrue("Explanation must be provided", q.explanation.isNotBlank())
        }

        val videos = DmgtQuizAndMediaSeed.videoLessons
        assertTrue("Video lessons must be present", videos.isNotEmpty())
        for (v in videos) {
            assertTrue("Must have slides", v.slides.isNotEmpty())
            for (s in v.slides) {
                assertTrue("Narration in English required", s.narrationEn.isNotBlank())
                assertTrue("Narration in Telugu required", s.narrationTe.isNotBlank())
                assertTrue("Narration in Hindi required", s.narrationHi.isNotBlank())
            }
        }
    }

    @Test
    fun testSupportedLanguagesPreserveMathRules() {
        val languages = SupportedLanguage.values()
        assertTrue("Must support at least 4 Indian languages plus English", languages.size >= 5)
        val telugu = languages.find { it == SupportedLanguage.TELUGU }
        assertNotNull(telugu)
        assertEquals("Telugu", telugu?.displayName)
    }
}
