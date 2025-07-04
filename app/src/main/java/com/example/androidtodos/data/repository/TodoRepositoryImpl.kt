package com.example.androidtodos.data.repository

import com.example.androidtodos.data.local.TodoDao
import com.example.androidtodos.data.mappers.toEntity
import com.example.androidtodos.domain.model.Todo
import com.example.androidtodos.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val dao: TodoDao): TodoRepository {
    override fun getTodos(): Flow<List<Todo>> =
        dao.getAllTodos().map { entities ->
            entities.map {
                Todo(it.id, it.title, it.isDone)
            }
        }

    override suspend fun addTodo(todo: Todo) {
        dao.insert(todo.toEntity())
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.delete(todo.toEntity())
    }

    override suspend fun updateTodo(todo: Todo) {
        dao.update(todo.toEntity())
    }
}