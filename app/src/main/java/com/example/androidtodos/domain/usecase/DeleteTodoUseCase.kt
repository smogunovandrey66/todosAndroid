package com.example.androidtodos.domain.usecase

import com.example.androidtodos.domain.model.Todo
import com.example.androidtodos.domain.repository.TodoRepository
import javax.inject.Inject

class DeleteTodoUseCase @Inject constructor(private val repo: TodoRepository) {
    suspend operator fun invoke(todo: Todo) = repo.deleteTodo(todo)
}