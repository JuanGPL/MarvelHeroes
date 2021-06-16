package com.juanleodev.marvelheroes.domain.boundary

import com.juanleodev.marvelheroes.domain.model.Hero

interface HeroesDataSource {

    fun getHeroes(offset: Int): List<Hero>

    fun getHero(heroId: Int): Hero

}