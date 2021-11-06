package com.happymoonday.challengesforheymoon.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.happymoonday.challengesforheymoon.data.network.MovieRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

open class BaseViewModel: ViewModel() {

    @JvmField
    val showProgress = MutableLiveData<Boolean>()
    protected val repository = MovieRepository.getInstance()
    private var onDestroyDisposable = CompositeDisposable()

    fun showProgress() {
        showProgress.value = true
    }

    fun hideProgress() {
        showProgress.value = false
    }

    /**
     * ViewModel 에서만 호출
     */
    protected fun Disposable.addToOnDestroyDisposable() {
        addTo(onDestroyDisposable)
    }

}

typealias TypeCallback<T> = (T) -> Unit

typealias StringCallback = ((String?) -> Unit)?