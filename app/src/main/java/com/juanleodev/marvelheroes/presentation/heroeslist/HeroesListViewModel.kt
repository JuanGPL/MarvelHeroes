package com.juanleodev.marvelheroes.presentation.heroeslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.usecase.GetHeroes
import com.juanleodev.marvelheroes.presentation.heroeslist.mapper.HeroesListMapper
import com.juanleodev.marvelheroes.presentation.heroeslist.model.HeroListItem
import kotlinx.coroutines.launch

class HeroesListViewModel(
    private val getHeroes: GetHeroes,
    private val mapper: HeroesListMapper
) : ViewModel() {

    private val tag = javaClass.simpleName

    private val heroesListCached: ArrayList<HeroListItem> = ArrayList()
    private val heroesListLiveData = MutableLiveData<List<HeroListItem>>()
    fun getHeroesListObservable(): LiveData<List<HeroListItem>> = heroesListLiveData

    fun getHeroesList() {
        viewModelScope.launch {
            when(val heroesListResult = getHeroes(heroesListCached.size)) {
                is Resource.Success -> {
                    val heroesList = mapper(heroesListResult.data)
                    heroesListCached.addAll(heroesList)
                    heroesListLiveData.postValue(heroesListCached)
                }

                is Resource.Error -> {
                    // TODO: show snackbar error
                    Log.e(tag, "ERROR: $heroesListResult")
                }
            }
        }
    }

}