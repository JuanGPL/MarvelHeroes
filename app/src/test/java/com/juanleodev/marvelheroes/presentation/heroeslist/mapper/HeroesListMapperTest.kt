package com.juanleodev.marvelheroes.presentation.heroeslist.mapper

import com.juanleodev.marvelheroes.domain.model.Hero
import org.junit.Assert.assertEquals
import org.junit.Test

class HeroesListMapperTest {

    @Test
    fun invokeTest_emptyList() {
        val mapper = HeroesListMapper()
        val result = mapper(ArrayList())
        assertEquals(0, result.size)
    }

    @Test
    fun invokeTest_InvalidItems() {
        val mapper = HeroesListMapper()
        val items: ArrayList<Hero> = ArrayList()
        items.add(Hero())
        items.add(Hero())
        val result = mapper(items)
        assertEquals(0, result.size)
    }

    @Test
    fun invokeTest_Success() {
        val mapper = HeroesListMapper()
        val items: ArrayList<Hero> = ArrayList()
        items.add(Hero(1, name = "The hero"))
        items.add(Hero())
        val result = mapper(items)
        assertEquals(1, result.size)
    }

}