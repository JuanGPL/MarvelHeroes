package com.juanleodev.marvelheroes.data.web.mapper

import com.juanleodev.marvelheroes.data.web.model.CharacterDataWrapper
import com.juanleodev.marvelheroes.data.web.model.ComicList
import com.juanleodev.marvelheroes.data.web.model.SeriesList
import com.juanleodev.marvelheroes.data.web.model.StoryList
import com.juanleodev.marvelheroes.domain.model.Comic
import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.domain.model.Serie
import com.juanleodev.marvelheroes.domain.model.Story
import java.util.*

class HeroesMapper {

    companion object {
        fun mapToHeroList(response: CharacterDataWrapper): List<Hero> {
            val heroList: ArrayList<Hero> = ArrayList()

            response.data?.results?.forEach {
                with(it) {
                    val hero = Hero(
                        id,
                        name,
                        description,
                        resourceURI,
                        mapComics(comics),
                        mapStories(stories),
                        mapSeries(series)
                    )
                    heroList.add(hero)
                }
            }

            return heroList
        }

        fun mapComics(comicList: ComicList?): List<Comic> {
            val comics: ArrayList<Comic> = ArrayList()

            comicList?.items?.forEach {
                with(it) {
                    val comic = Comic(
                        name,
                        resourceURI
                    )
                    comics.add(comic)
                }
            }

            return comics
        }

        fun mapStories(storyList: StoryList?): List<Story> {
            val stories: ArrayList<Story> = ArrayList()

            storyList?.items?.forEach {
                with(it) {
                    val story = Story(
                        name,
                        resourceURI,
                        type
                    )
                    stories.add(story)
                }
            }

            return stories
        }

        fun mapSeries(serieList: SeriesList?): List<Serie> {
            val series: ArrayList<Serie> = ArrayList()

            serieList?.items?.forEach {
                with(it) {
                    val serie = Serie(
                        name,
                        resourceURI
                    )
                    series.add(serie)
                }
            }

            return series
        }
    }

}