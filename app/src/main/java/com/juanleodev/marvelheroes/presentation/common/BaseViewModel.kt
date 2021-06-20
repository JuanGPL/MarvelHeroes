package com.juanleodev.marvelheroes.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    protected val loadingLiveData = MutableLiveData<Boolean>()
    fun getLoadingObservable(): LiveData<Boolean> = loadingLiveData

    private val errorLiveData = MutableLiveData<String>()
    fun getErrorObservable(): LiveData<String> = errorLiveData

    protected fun showLoading(mustShow: Boolean) {
        loadingLiveData.postValue(mustShow)
    }

    protected fun showError(exception: Exception) {
        showLoading(false)
        errorLiveData.postValue(exception.message)
    }

}