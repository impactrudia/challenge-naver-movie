package com.happymoonday.challengesforheymoon.data.network

import com.happymoonday.challengesforheymoon.domain.model.Movie
import com.happymoonday.challengesforheymoon.data.network.response.BaseResponse
import io.reactivex.Single
import retrofit2.http.*

/**
 * server url 을 사용하는 api 모음.
 */
interface MovieRestApi {

    /**
     * 검색 > 영화
     */
    @GET("/v1/search/movie.json")
    fun searchMovies(
        @Query("query") query: String,
        @Query("genre") genre: Int?,
        @Query("country") country: String?
    ): Single<BaseResponse<List<Movie>>>

}