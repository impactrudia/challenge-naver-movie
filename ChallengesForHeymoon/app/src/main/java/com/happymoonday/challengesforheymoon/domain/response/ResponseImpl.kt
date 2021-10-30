package com.happymoonday.challengesforheymoon.domain.response


/**
 * API 리스판스 공통 클래스
 */
interface ResponseImpl {
    val status: String?
    val errorMessage: String?
    val errorCode: String?
}