package com.example.androidtodos.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidtodos.domain.model.Todo
import com.example.androidtodos.presentation.TodoViewModel
import com.example.androidtodos.ui.screens.TodoScreen
import com.example.androidtodos.ui.theme.AndroidTodosTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Todos") }
                    )
                }
            ) { innerPadding ->
                MainContent(innerPadding)
            }
        }
    }

}

@Composable
fun MainContent(paddingValues: PaddingValues) {
    AndroidTodosTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val viewModel: TodoViewModel = hiltViewModel()
            val todos by viewModel.todos.collectAsState()

            TodoScreen(
                paddingValues = paddingValues,
                todos = todos,
                onAddTodo = { title ->
                    val todo = Todo(title = title, isDone = false)
                    viewModel.addTodo(todo)
                },
                onToggleTodo = { todo ->
                    viewModel.updateTodo(Todo(todo.id, todo.title, !todo.isDone))
                },
                onDeleteTodo = { todo ->
                    viewModel.deleteTodo(todo)
                }
            )
        }
    }
}