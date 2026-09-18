package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey val id: String,
    val itemType: String = "question", // "question", "topic", "formula"
    val title: String,
    val unitNumber: Int,
    val snippet: String = "",
    val topic: String = "",
    val marks: Int = 2,
    val sourceRef: String = "",
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "quiz_records")
data class QuizRecordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val quizTitle: String,
    val unitNumber: Int = 0,
    val score: Int,
    val totalQuestions: Int,
    val dateEpoch: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey val userId: String = "default_user",
    val completedTopicsJson: String = "[]",
    val solvedQuestionsJson: String = "[]",
    val openedPdfsJson: String = "[]",
    val watchedVideosJson: String = "[]",
    val studyStreak: Int = 1,
    val currentStreak: Int = 1,
    val questionsReadCount: Int = 0,
    val readQuestionIds: String = "",
    val quizzesCompleted: Int = 0,
    val avgQuizScore: Int = 0,
    val lastStudyDateEpoch: Long = System.currentTimeMillis(),
    val lastActiveDate: Long = System.currentTimeMillis()
)

@Entity(tableName = "custom_questions")
data class CustomQuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val unitNumber: Int,
    val topic: String,
    val questionText: String,
    val marks: Int,
    val questionType: String = "5-Mark", // 2-Mark, 5-Mark, 10-Mark
    val answer: String = "",
    val formula: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
