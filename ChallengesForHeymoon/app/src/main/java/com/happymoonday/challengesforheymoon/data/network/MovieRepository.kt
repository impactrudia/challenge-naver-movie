package com.happymoonday.challengesforheymoon.data.network

import com.happymoonday.challengesforheymoon.data.network.reqeuest.ReqMovie
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * API 공통 모듈
 */
class MovieRepository private constructor() {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MovieRepository().also { instance = it }
        }
    }

    private val organApi by lazy {
        ServiceFactory().getOrganApi()
    }

    fun searchMovies(reqMovie: ReqMovie?) = organApi.searchMovies(reqMovie?.keyword?:"", reqMovie?.genre?.id, reqMovie?.nation?.id)
        .observeOn(AndroidSchedulers.mainThread())

}
