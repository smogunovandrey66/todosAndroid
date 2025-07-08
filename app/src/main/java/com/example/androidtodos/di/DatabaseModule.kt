package com.example.androidtodos.di

import android.content.Context
import androidx.room.Room
import com.example.androidtodos.data.local.TodoDao
import com.example.androidtodos.data.local.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todos.db"
        ).build()
    }

    @Provides
    fun provideTodoDao(db: TodoDatabase): TodoDao = db.todoDao
}