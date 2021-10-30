package com.happymoonday.challengesforheymoon.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Movie(
   val link : String,
   val title : String?,
   val image : String?,
   val subtitle : String?,
   val pubDate : String?,
   val director : String?,
   val actor : String?,
   val userRating : String?
):Serializable {
   @PrimaryKey(autoGenerate = true) var uuid: Int = 0

   fun setUUid(uuid: Int) {
      this.uuid = uuid
   }

   fun getUid(): Int? {
      return this.uuid
   }
}