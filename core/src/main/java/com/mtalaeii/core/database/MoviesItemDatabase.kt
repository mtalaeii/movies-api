package com.mtalaeii.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mtalaeii.core.model.Data

@Database(
    entities = [Data::class],
    version = 1
)
abstract class MoviesItemDatabase:RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}