package com.example.androidtodos.domain.usecase

import com.example.androidtodos.domain.model.Todo
import com.example.androidtodos.domain.repository.TodoRepository
import javax.inject.Inject

class GetTodosUseCase @Inject constructor(private val repo: TodoRepository) {
    operator fun invoke() = repo.getTodos()
}