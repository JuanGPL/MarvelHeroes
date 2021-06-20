package com.juanleodev.marvelheroes.presentation.heroeslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.usecase.GetHeroes
import com.juanleodev.marvelheroes.presentation.common.BaseViewModel
import com.juanleodev.marvelheroes.presentation.heroeslist.mapper.HeroesListMapper
import com.juanleodev.marvelheroes.presentation.heroeslist.model.HeroListItem
import kotlinx.coroutines.launch

class HeroesListViewModel(
    private val getHeroes: GetHeroes,
    private val mapper: HeroesListMapper
) : BaseViewModel() {

    private val heroesListCached: ArrayList<HeroListItem> = ArrayList()
    private val heroesListLiveData = MutableLiveData<List<HeroListItem>>()
    fun getHeroesListObservable(): LiveData<List<HeroListItem>> = heroesListLiveData

    fun getHeroesList() {
        showLoading(true)
        viewModelScope.launch {
            when (val heroesListResult = getHeroes(heroesListCached.size)) {
                is Resource.Success -> {
                    val heroesList = mapper(heroesListResult.data)
                    heroesListCached.addAll(heroesList)
                    heroesListLiveData.postValue(heroesListCached)
                    showLoading(false)
                }

                is Resource.Error -> {
                    showError(heroesListResult.error)
                }
            }
        }
    }

}