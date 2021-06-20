package com.juanleodev.marvelheroes.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    protected val loadingLiveData = MutableLiveData<Boolean>()
    fun getLoadingObservable(): LiveData<Boolean> = loadingLiveData

}