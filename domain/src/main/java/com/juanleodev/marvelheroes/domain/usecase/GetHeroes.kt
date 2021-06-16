package com.juanleodev.marvelheroes.domain.usecase

import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource
import com.juanleodev.marvelheroes.domain.model.Hero

class GetHeroes(
    private val heroesDataSource: HeroesDataSource
) {

    operator fun invoke(offset: Int): List<Hero> = heroesDataSource.getHeroes(offset)

}