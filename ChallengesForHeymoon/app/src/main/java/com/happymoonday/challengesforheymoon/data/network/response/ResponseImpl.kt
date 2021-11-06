package com.happymoonday.challengesforheymoon.data.network.response


/**
 * API 리스판스 공통 클래스
 */
interface ResponseImpl {

    val status: String?
    val errorMessage: String?
    val errorCode: String?

}