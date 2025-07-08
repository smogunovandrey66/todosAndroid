package com.example.androidtodos.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.androidtodos.domain.model.Todo

@Composable
fun TodoScreen(
    paddingValues: PaddingValues,
    todos: List<Todo>,
    onAddTodo: (String) -> Unit,
    onToggleTodo: (Todo) -> Unit,
    onDeleteTodo: (Todo) -> Unit
) {
    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = input,
                onValueChange = { input = it },
                placeholder = { Text("Enter todo") },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp, start = 8.dp)
            )
            Button(onClick = {
                if (input.isNotBlank()) {
                    onAddTodo(input)
                    Log.d("TEST", "click")
                    input = ""
                }
            }) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(todos) { todo ->
                TodoItem(todo, onToggleTodo, onDeleteTodo)
                Divider()
            }
        }
    }
}

@Composable
fun TodoItem(
    todo: Todo,
    onToggle: (Todo) -> Unit,
    onDelete: (Todo) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.isDone,
            onCheckedChange = { onToggle(todo) }
        )

        Text(
            text = todo.title,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            textDecoration = if (todo.isDone) TextDecoration.LineThrough else null
        )

        IconButton(onClick = {onDelete(todo)}) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}