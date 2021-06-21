package com.juanleodev.marvelheroes.presentation.herodetail.mapper

import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.presentation.herodetail.model.HeroDetail
import org.junit.Assert.*
import org.junit.Test

class HeroDetailMapperTest {

    @Test
    fun invokeTest_NullParametersResultNull() {
        val mapper = HeroDetailMapper()
        val result = mapper(Hero())
        assertNull(result)
    }

    @Test
    fun invokeTest_Success() {
        val mapper = HeroDetailMapper()
        val result: HeroDetail? = mapper(Hero(1, "Name"))
        assertNotNull(result)
        assertEquals("Name", result?.name)
    }
}