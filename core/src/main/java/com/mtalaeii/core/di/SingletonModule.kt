package com.mtalaeii.core.di

import android.content.Context
import androidx.room.Room
import com.mtalaeii.core.database.MoviesDao
import com.mtalaeii.core.database.MoviesItemDatabase
import com.mtalaeii.core.repositories.DefaultMovieRepository
import com.mtalaeii.core.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Singleton
    @Provides
    fun provideDefaultMovieRepository(
        dao: MoviesDao
    ) = DefaultMovieRepository(dao) as MoviesRepository

    @Singleton
    @Provides
    fun provideShoppingItemDataBase(
        @ApplicationContext context: Context
    )= Room.databaseBuilder(context, MoviesItemDatabase::class.java,"movies_items").build()

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: MoviesItemDatabase
    )=database.moviesDao()
}