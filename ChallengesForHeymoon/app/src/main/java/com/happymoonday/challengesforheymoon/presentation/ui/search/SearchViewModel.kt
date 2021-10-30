package com.happymoonday.challengesforheymoon.presentation.ui.search

import com.happymoonday.challengesforheymoon.domain.model.Movie
import com.happymoonday.challengesforheymoon.domain.model.reqeuest.ReqMovie
import com.happymoonday.challengesforheymoon.domain.response.BaseResponse
import com.happymoonday.challengesforheymoon.presentation.base.BaseViewModel
import com.happymoonday.challengesforheymoon.presentation.base.StringCallback
import com.happymoonday.challengesforheymoon.presentation.base.TypeCallback
import io.reactivex.rxkotlin.subscribeBy

class SearchViewModel : BaseViewModel() {

    var movie: ReqMovie? = ReqMovie()

    fun requestSearchMovie(
        success: TypeCallback<BaseResponse<List<Movie>>>,
        error: StringCallback
    ) {
        showProgress()
        repository.searchMovies(movie)
            .doFinally { hideProgress() }
            .subscribeBy(onSuccess = {
                success.invoke(it)
            }, onError = {
            })
            .addToOnDestroyDisposable()
    }

}