package com.example.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarks ORDER BY timestamp DESC")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE id = :id)")
    fun isBookmarked(id: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE id = :id")
    suspend fun deleteBookmarkById(id: String)
}

@Dao
interface QuizRecordDao {
    @Query("SELECT * FROM quiz_records ORDER BY dateEpoch DESC")
    fun getAllQuizRecords(): Flow<List<QuizRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizRecord(record: QuizRecordEntity)
}

@Dao
interface UserProgressDao {
    @Query("SELECT * FROM user_progress WHERE userId = :userId LIMIT 1")
    fun getProgress(userId: String = "default_user"): Flow<UserProgressEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProgress(progress: UserProgressEntity)
}

@Dao
interface CustomQuestionDao {
    @Query("SELECT * FROM custom_questions ORDER BY timestamp DESC")
    fun getAllCustomQuestions(): Flow<List<CustomQuestionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomQuestion(question: CustomQuestionEntity)

    @Query("DELETE FROM custom_questions WHERE id = :id")
    suspend fun deleteCustomQuestion(id: Long)
}
