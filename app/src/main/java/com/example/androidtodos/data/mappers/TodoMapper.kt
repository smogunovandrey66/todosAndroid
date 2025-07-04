package com.example.androidtodos.data.mappers

import com.example.androidtodos.data.local.entity.TodoEntity
import com.example.androidtodos.domain.model.Todo

fun TodoEntity.toDomain(): Todo = Todo(id, title, isDone)
fun Todo.toEntity(): TodoEntity = TodoEntity(id, title, isDone)
