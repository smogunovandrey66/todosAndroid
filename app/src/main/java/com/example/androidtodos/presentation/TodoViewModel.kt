package com.example.androidtodos.presentation

import androidx.lifecycle.ViewModel
import com.example.androidtodos.domain.usecase.AddTodoUseCase
import com.example.androidtodos.domain.usecase.DeleteTodoUseCase
import com.example.androidtodos.domain.usecase.GetTodosUseCase
import com.example.androidtodos.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    getTodosUseCase: GetTodosUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase
) : ViewModel() {
}

