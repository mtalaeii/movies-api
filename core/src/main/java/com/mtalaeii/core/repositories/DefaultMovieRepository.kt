package com.mtalaeii.core.repositories

import androidx.lifecycle.LiveData
import com.mtalaeii.core.database.MoviesDao
import com.mtalaeii.core.model.Data
import javax.inject.Inject

class DefaultMovieRepository @Inject constructor(
    val moviesDao: MoviesDao
) : MoviesRepository {
    override suspend fun insertMovieItem(item: Data) {
        moviesDao.insertMovieItem(item)
    }

    override suspend fun deleteMovieItem(item: Data) {
        moviesDao.deleteMovieItem(item)
    }

    override fun observeAllMoviesItems(): LiveData<List<Data>> {
        return moviesDao.observeAllMoviesItems()
    }

    override fun getItemById(id: Int): LiveData<Data> {
        return moviesDao.getItemById(id)
    }

}