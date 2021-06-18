package com.juanleodev.marvelheroes.domain.boundary

import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.model.Hero

interface HeroesDataSource {

    suspend fun getHeroes(offset: Int): Resource<List<Hero>>

    suspend fun getHero(heroId: Int): Resource<Hero>

}