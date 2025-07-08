package com.example.androidtodos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtodos.domain.model.Todo
import com.example.androidtodos.domain.usecase.AddTodoUseCase
import com.example.androidtodos.domain.usecase.DeleteTodoUseCase
import com.example.androidtodos.domain.usecase.GetTodosUseCase
import com.example.androidtodos.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    getTodosUseCase: GetTodosUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase
) : ViewModel() {

    val todos: StateFlow<List<Todo>> = getTodosUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000), initialValue = emptyList()
    )

    fun addTodo(todo: Todo) = viewModelScope.launch {
        addTodoUseCase(todo)
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch {
        deleteTodoUseCase(todo)
    }

    fun  updateTodo(todo: Todo) = viewModelScope.launch {
        updateTodoUseCase(todo)
    }
}

