package com.happymoonday.challengesforheymoon.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.happymoonday.challengesforheymoon.domain.model.Movie

/**
 * 내부 데이터베이스
 */
@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}