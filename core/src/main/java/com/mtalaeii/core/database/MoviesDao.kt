package com.mtalaeii.core.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mtalaeii.core.model.Data

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieItem(item:Data)
    @Delete
    suspend fun deleteMovieItem(item: Data)
    @Query("SELECT * FROM `movies_items`")
    fun observeAllMoviesItems():LiveData<List<Data>>
    @Query("SELECT * FROM `movies_items` WHERE `id` = :id LIMIT 1")
    fun getItemById(id:Int):LiveData<Data>
}