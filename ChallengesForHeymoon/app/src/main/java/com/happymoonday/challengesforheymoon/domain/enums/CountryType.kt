package com.happymoonday.challengesforheymoon.domain.enums

enum class CountryType(var id: String, var toDescription: String) {
    KOREA("KR","한국"),
    JAPAN("JP","일본"),
    UNITED_STATES("US","미국"),
    HONG_KONG("HK","홍콩"),
    UK("GB","영국"),
    FRANCE("FR","프랑스"),
    OTHERS("ETC","기타");

    companion object {
        fun findNationTypeList(): List<CountryType> {
            return CountryType.values().toList()
        }
    }
}