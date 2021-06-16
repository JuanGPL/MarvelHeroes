package com.juanleodev.marvelheroes.presentation.heroeslist

import androidx.lifecycle.ViewModel
import com.juanleodev.marvelheroes.domain.usecase.GetHeroes

class HeroesListViewModel(
    private val getHeroes: GetHeroes
) : ViewModel() {
}