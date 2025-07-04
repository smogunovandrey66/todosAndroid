package com.example.androidtodos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtodos.data.local.entity.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract val todoDao: TodoDao
}