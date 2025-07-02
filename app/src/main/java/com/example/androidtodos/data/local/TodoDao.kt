package com.example.androidtodos.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidtodos.data.local.entity.TodoEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {
    @Query("Select * from todos")
    fun getAllTodos(): Flow<List<TodoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: TodoEntity)

    @Delete
    suspend fun delete(todo: TodoEntity)

    @Update
    suspend fun update(todo: TodoEntity)
}