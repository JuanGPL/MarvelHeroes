package com.juanleodev.marvelheroes.presentation.herodetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.usecase.GetHero
import com.juanleodev.marvelheroes.presentation.common.BaseViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.mapper.HeroDetailMapper
import com.juanleodev.marvelheroes.presentation.herodetail.model.HeroDetail
import kotlinx.coroutines.launch

class HeroDetailViewModel(
    private val getHero: GetHero,
    private val mapper: HeroDetailMapper
) : BaseViewModel() {

    private val tag = javaClass.simpleName

    private val heroDetailLiveData = MutableLiveData<HeroDetail>()
    fun getHeroDetailObservable(): LiveData<HeroDetail> = heroDetailLiveData

    fun getHeroDetail(heroId: Int) {
        loadingLiveData.postValue(true)
        viewModelScope.launch {
            when (val heroResult = getHero(heroId)) {
                is Resource.Success -> {
                    val heroDetail = mapper(heroResult.data)
                    heroDetailLiveData.postValue(heroDetail)
                    loadingLiveData.postValue(false)
                }

                is Resource.Error -> {
                    // TODO: show snackbar error
                    Log.e(tag, "ERROR: $heroResult")
                    loadingLiveData.postValue(false)
                }
            }
        }
    }

}