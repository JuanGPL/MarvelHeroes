package com.juanleodev.marvelheroes.presentation.herodetail.mapper

import com.juanleodev.marvelheroes.domain.model.Comic
import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.domain.model.Serie
import com.juanleodev.marvelheroes.domain.model.Story
import com.juanleodev.marvelheroes.presentation.herodetail.model.HeroDetail

class HeroDetailMapper {

    operator fun invoke(hero: Hero): HeroDetail? {
        return if (hero.name.isNullOrEmpty() && hero.imageHiRes.isNullOrEmpty()) {
            null
        } else
            HeroDetail(
                hero.id,
                hero.name,
                hero.description,
                hero.image,
                mapComics(hero.comics),
                mapSeries(hero.series),
                mapStories(hero.stories)
            )
    }

    private fun mapComics(comics: List<Comic>?): List<String> {
        val comicList: ArrayList<String> = ArrayList()

        comics?.forEach {
            it.name?.let { name -> comicList.add(name) }
        }

        return comicList
    }

    private fun mapSeries(series: List<Serie>?): List<String> {
        val seriesList: ArrayList<String> = ArrayList()

        series?.forEach {
            it.name?.let { name -> seriesList.add(name) }
        }

        return seriesList
    }

    private fun mapStories(stories: List<Story>?): List<String> {
        val storiesList: ArrayList<String> = ArrayList()

        stories?.forEach {
            it.name?.let { name -> storiesList.add(name) }
        }

        return storiesList
    }

}