package com.happymoonday.challengesforheymoon.domain.enums

enum class GenreType(var id: Int, var toDescription: String) {
    DRAMA(1, "드라마"),
    FANTASY(2, "판타지"),
    WEST(3, "서부"),
    HORROR(4, "공포"),
    ROMANCE(5, "로맨스"),
    ADVENTURE(6, "모험"),
    THRILLER(7, "스릴러"),
    NOIR(8, "느와르"),
    CULT(9, "컬트"),
    DOCUMENTARY(10, "다큐멘터리"),
    COMEDY(11, "코미디"),
    FAMILY(12, "가족"),
    MYSTERY(13, "미스터리"),
    WAR(14, "전쟁"),
    ANIMATION(15, "애니메이션"),
    CRIME(16, "범죄"),
    MUSICAL(17, "뮤지컬"),
    SF(18, "SF"),
    ACTION(19, "액션"),
    MARTIAL_ARTS(20, "무협"),
    EROTIC(21, "에로"),
    SUSPENSE(22, "서스펜스"),
    EPIC(23, "서사"),
    BLACK_COMEDY(24, "블랙코미디"),
    EXPERIMENT(25, "실험"),
    MOVIE_CARTOON(26, "영화카툰"),
    MOVIE_MUSIC(27, "영화음악"),
    MOVIE_PARODY_POSTER(28, "영화패러디포스터");

    companion object {
        fun findGenreTypeList(): List<GenreType> {
            return values().toList()
        }
    }
}