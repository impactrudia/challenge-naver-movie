package com.happymoonday.challengesforheymoon.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.io.Serializable


@Entity
data class Movie(
    val link: String?,
    val title: String?,
    val image: String?,
    val subtitle: String?,
    val pubDate: String?,
    val director: String?,
    val actor: String?,
    val userRating: String?
) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

    fun setUUid(uuid: Int) {
        this.uuid = uuid
    }

    fun getUid(): Int? {
        return this.uuid
    }

    private fun removeSeparator(input: String?): String? {
        val directors = input?.split("|")
        return directors?.filter { it.isNotEmpty() }?.joinToString(",")
    }

    fun formatDirector(): String? {
        return removeSeparator(director)
    }

    fun formatActor(): String? {
        return removeSeparator(actor)
    }

}