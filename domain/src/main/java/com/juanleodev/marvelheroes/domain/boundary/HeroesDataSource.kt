package com.juanleodev.marvelheroes.domain.boundary

import com.juanleodev.marvelheroes.domain.model.Hero

interface HeroesDataSource {

    suspend fun getHeroes(offset: Int): List<Hero>

    suspend fun getHero(heroId: Int): Hero

}