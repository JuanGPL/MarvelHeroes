package com.juanleodev.marvelheroes.domain.usecase

import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource

class GetHeroes(
    private val heroesDataSource: HeroesDataSource
) {

    suspend operator fun invoke(offset: Int = 0) = heroesDataSource.getHeroes(offset)

}