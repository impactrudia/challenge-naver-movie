package com.happymoonday.challengesforheymoon.data.network.response


/**
 * 네트워크 공통 클래 도메인 아님
 */
class BaseResponse<T> : ResponseImpl {

    override val errorMessage: String? = null
    override val errorCode: String? = null
    override val status: String? = null
    var items: T? = null
    val total: Int? = 0
    val start: Int? = 0
    val display: Int? = 0

}
