package com.juanleodev.marvelheroes.presentation.herodetail

import androidx.lifecycle.ViewModel
import com.juanleodev.marvelheroes.domain.usecase.GetHero

class HeroDetailViewModel(
    private val getHero: GetHero
) : ViewModel() {
}