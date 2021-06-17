package com.juanleodev.marvelheroes.data.web.repository

import com.google.gson.Gson
import com.juanleodev.marvelheroes.data.web.api.MarvelHeroesApi
import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource
import com.juanleodev.marvelheroes.domain.model.Hero

class HeroesRepository(
    private val api: MarvelHeroesApi,
    gson: Gson,
) : Repository(gson), HeroesDataSource {

    override suspend fun getHeroes(offset: Int): List<Hero> {
        TODO("Not yet implemented")
    }

    override suspend fun getHero(heroId: Int): Hero {
        TODO("Not yet implemented")
    }

}