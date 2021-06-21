package com.juanleodev.marvelheroes.presentation.herodetail

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

    private val heroDetailLiveData = MutableLiveData<HeroDetail?>()
    fun getHeroDetailObservable(): LiveData<HeroDetail?> = heroDetailLiveData

    fun getHeroDetail(heroId: Int) {
        showLoading(true)
        viewModelScope.launch {
            when (val heroResult = getHero(heroId)) {
                is Resource.Success -> {
                    val heroDetail = mapper(heroResult.data)
                    heroDetailLiveData.postValue(heroDetail)
                    showLoading(false)
                }

                is Resource.Error -> {
                    showError(heroResult.error)
                }
            }
        }
    }

}