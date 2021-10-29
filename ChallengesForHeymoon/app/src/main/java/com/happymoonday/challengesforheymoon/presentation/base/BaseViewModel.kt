package com.happymoonday.challengesforheymoon.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    @JvmField
    val showProgress = MutableLiveData<Boolean>()

    fun showProgress() {
        showProgress.value = true
    }

    fun hideProgress() {
        showProgress.value = false
    }
}