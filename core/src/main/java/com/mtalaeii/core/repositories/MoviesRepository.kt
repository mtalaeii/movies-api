package com.mtalaeii.core.repositories

import androidx.lifecycle.LiveData
import com.mtalaeii.core.model.Data
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun insertMovieItem(item: Data)
    suspend fun deleteMovieItem(item: Data)
    fun observeAllMoviesItems(): LiveData<List<Data>>
    fun getItemById(id:Int): LiveData<Data>
}