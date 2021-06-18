package com.juanleodev.marvelheroes.domain.usecase

import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource

class GetHero(
    private val heroesDataSource: HeroesDataSource
) {

    suspend operator fun invoke(heroId: Int) = heroesDataSource.getHero(heroId)

}