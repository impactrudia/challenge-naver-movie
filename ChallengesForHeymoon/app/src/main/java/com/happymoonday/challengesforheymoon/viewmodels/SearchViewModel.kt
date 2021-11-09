package com.happymoonday.challengesforheymoon.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.happymoonday.challengesforheymoon.data.network.reqeuest.ReqMovie
import com.happymoonday.challengesforheymoon.data.network.response.BaseResponse
import com.happymoonday.challengesforheymoon.domain.enums.CountryType
import com.happymoonday.challengesforheymoon.domain.enums.GenreType
import com.happymoonday.challengesforheymoon.domain.model.Movie
import com.happymoonday.challengesforheymoon.presentation.base.BaseViewModel
import com.happymoonday.challengesforheymoon.presentation.base.StringCallback
import com.happymoonday.challengesforheymoon.presentation.base.TypeCallback
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.flow.asFlow

class SearchViewModel : BaseViewModel() {

    var reqMovie: ReqMovie? = ReqMovie()
    val genres: LiveData<List<GenreType>> = { GenreType.findGenreTypeList() }.asFlow().asLiveData()
    val countries: LiveData<List<CountryType>> =
        { CountryType.findNationTypeList() }.asFlow().asLiveData()

    fun requestSearchMovie(
        success: TypeCallback<BaseResponse<List<Movie>>>,
        error: StringCallback
    ) {
        showProgress()
        repository.searchMovies(reqMovie)
            .doFinally { hideProgress() }
            .subscribeBy(onSuccess = {
                success.invoke(it)
            }, onError = {
                error?.invoke("")
            })
            .addToOnDestroyDisposable()
    }

}