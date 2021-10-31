package com.happymoonday.challengesforheymoon.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.happymoonday.challengesforheymoon.domain.model.Movie

/**
 * 내부 데이터베이스 Movie CRUD
 */
@Dao
interface MovieDao {
    @Query("select * from movie")
    suspend fun getAll(): List<Movie>

    @Insert
    suspend fun insertMovie(movie: Movie)

    @Query("DELETE FROM movie WHERE uuid = :uuid")
    fun deleteByUuid(uuid: Int)
}