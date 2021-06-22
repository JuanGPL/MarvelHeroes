package com.juanleodev.marvelheroes.domain.boundary

import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.model.Comic
import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.domain.model.Serie
import com.juanleodev.marvelheroes.domain.model.Story

interface HeroesDataSource {

    suspend fun getHeroes(offset: Int): Resource<List<Hero>>

    suspend fun getHero(heroId: Int): Resource<Hero>

    suspend fun getComics(heroId: Int, offset: Int): Resource<List<Comic>>

    suspend fun getSeries(heroId: Int, offset: Int): Resource<List<Serie>>

    suspend fun getStories(heroId: Int, offset: Int): Resource<List<Story>>

}