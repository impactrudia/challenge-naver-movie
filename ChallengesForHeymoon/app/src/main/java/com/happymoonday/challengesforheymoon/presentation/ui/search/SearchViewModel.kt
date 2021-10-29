package com.happymoonday.challengesforheymoon.presentation.ui.search

import androidx.lifecycle.LiveData
import com.happymoonday.challengesforheymoon.domain.model.Movie
import com.happymoonday.challengesforheymoon.domain.model.reqeuest.ReqMovie
import com.happymoonday.challengesforheymoon.presentation.base.BaseViewModel

class SearchViewModel : BaseViewModel() {
    var movie: ReqMovie? = ReqMovie()
    val searchMovies: LiveData<List<Movie>>? = null
}