package com.juanleodev.marvelheroes.presentation.herodetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.usecase.GetHero
import com.juanleodev.marvelheroes.presentation.herodetail.mapper.HeroDetailMapper
import com.juanleodev.marvelheroes.presentation.herodetail.model.HeroDetail
import kotlinx.coroutines.launch

class HeroDetailViewModel(
    private val getHero: GetHero,
    private val mapper: HeroDetailMapper
) : ViewModel() {

    private val tag = javaClass.simpleName

    private val heroDetailLiveData = MutableLiveData<HeroDetail>()
    fun getHeroDetailObservable(): LiveData<HeroDetail> = heroDetailLiveData

    fun getHeroDetail(heroId: Int) {
        viewModelScope.launch {
            when(val heroResult = getHero(heroId)) {
                is Resource.Success -> {
                    val heroDetail = mapper(heroResult.data)
                    heroDetailLiveData.postValue(heroDetail)
                }

                is Resource.Error -> {
                    // TODO: show snackbar error
                    Log.e(tag, "ERROR: $heroResult")
                }
            }
        }
    }

}