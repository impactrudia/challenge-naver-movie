package com.happymoonday.challengesforheymoon.domain.enums

import androidx.annotation.StringRes
import com.happymoonday.challengesforheymoon.R

enum class CountryType(val id: String, @StringRes val toDescription: Int) {

    KOREA("KR", R.string.country_korea),
    JAPAN("JP", R.string.country_japan),
    UNITED_STATES("US", R.string.country_united_states),
    HONG_KONG("HK", R.string.country_hong_kong),
    UK("GB", R.string.country_uk),
    FRANCE("FR", R.string.country_france),
    OTHERS("ETC", R.string.country_others);

    companion object {
        fun findNationTypeList(): List<CountryType> {
            return values().toList()
        }
    }

}