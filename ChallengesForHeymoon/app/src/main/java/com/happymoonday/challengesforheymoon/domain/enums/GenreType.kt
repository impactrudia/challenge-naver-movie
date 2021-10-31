package com.happymoonday.challengesforheymoon.domain.enums

import androidx.annotation.StringRes
import com.happymoonday.challengesforheymoon.R

enum class GenreType(val id: Int, @StringRes val toDescription: Int) {
    DRAMA(1, R.string.genre_drama),
    FANTASY(2, R.string.genre_fantasy),
    WEST(3, R.string.genre_west),
    HORROR(4, R.string.genre_horror),
    ROMANCE(5, R.string.genre_romance),
    ADVENTURE(6, R.string.genre_adventure),
    THRILLER(7, R.string.genre_thriller),
    NOIR(8, R.string.genre_noir),
    CULT(9, R.string.genre_cult),
    DOCUMENTARY(10, R.string.genre_documentary),
    COMEDY(11, R.string.genre_comedy),
    FAMILY(12, R.string.genre_family),
    MYSTERY(13, R.string.genre_mystery),
    WAR(14, R.string.genre_war),
    ANIMATION(15, R.string.genre_animation),
    CRIME(16, R.string.genre_crime),
    MUSICAL(17, R.string.genre_musical),
    SF(18, R.string.genre_sf),
    ACTION(19, R.string.genre_action),
    MARTIAL_ARTS(20, R.string.genre_martial_arts),
    EROTIC(21, R.string.genre_erotic),
    SUSPENSE(22, R.string.genre_suspense),
    EPIC(23, R.string.genre_epic),
    BLACK_COMEDY(24, R.string.genre_black_comedy),
    EXPERIMENT(25, R.string.genre_experiment),
    MOVIE_CARTOON(26, R.string.genre_cartoon),
    MOVIE_MUSIC(27, R.string.genre_music),
    MOVIE_PARODY_POSTER(28, R.string.genre_parody_poster);

    companion object {
        fun findGenreTypeList(): List<GenreType> {
            return values().toList()
        }
    }
}