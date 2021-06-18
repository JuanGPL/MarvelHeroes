package com.juanleodev.marvelheroes.presentation.heroeslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.usecase.GetHeroes
import kotlinx.coroutines.launch

class HeroesListViewModel(
    private val getHeroes: GetHeroes
) : ViewModel() {

    private val tag = javaClass.simpleName

    fun getHeroesList() {
        viewModelScope.launch {
            when(val heroesListResult = getHeroes()) {
                is Resource.Success -> {
                    Log.e(tag, "SUCCESS - getHeroesList: $heroesListResult")
                }

                is Resource.Error -> {
                    Log.e(tag, "ERROR: $heroesListResult")
                }
            }
        }
    }

}