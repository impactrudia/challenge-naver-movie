package com.happymoonday.challengesforheymoon.data.network.reqeuest

import com.happymoonday.challengesforheymoon.domain.enums.CountryType
import com.happymoonday.challengesforheymoon.domain.enums.GenreType

class ReqMovie {
    var keyword: String? = null
    var genre: GenreType? = null
    var nation: CountryType? = null
}