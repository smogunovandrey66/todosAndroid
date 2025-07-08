package com.example.androidtodos.di

import com.example.androidtodos.data.local.TodoDao
import com.example.androidtodos.data.repository.TodoRepositoryImpl
import com.example.androidtodos.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideTodoRepository(dao: TodoDao): TodoRepository = TodoRepositoryImpl(dao)
}