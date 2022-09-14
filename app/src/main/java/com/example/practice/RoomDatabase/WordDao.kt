package com.example.practice.RoomDatabase

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("Delete from word_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(word: Word)
}