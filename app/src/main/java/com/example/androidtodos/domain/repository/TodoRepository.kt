package com.example.androidtodos.domain.repository

import com.example.androidtodos.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodos(): Flow<List<Todo>>
    suspend fun addTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
}