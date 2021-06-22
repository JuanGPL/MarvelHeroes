package com.juanleodev.marvelheroes.domain.usecase

import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource

class GetStories(
    private val heroesDataSource: HeroesDataSource
) {

    suspend operator fun invoke(heroId: Int, offset: Int) = heroesDataSource.getStories(heroId, offset)
}