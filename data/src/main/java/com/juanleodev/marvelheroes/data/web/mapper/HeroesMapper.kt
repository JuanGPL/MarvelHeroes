package com.juanleodev.marvelheroes.data.web.mapper

import com.juanleodev.marvelheroes.data.web.model.*
import com.juanleodev.marvelheroes.domain.model.Comic
import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.domain.model.Serie
import com.juanleodev.marvelheroes.domain.model.Story
import java.util.*

class HeroesMapper {

    companion object {
        fun mapToHeroList(response: CharacterDataWrapper, imageQuality: ImageQuality): List<Hero> {
            val heroList: ArrayList<Hero> = ArrayList()

            response.data?.results?.forEach {
                with(it) {
                    val hero = Hero(
                        id,
                        name,
                        description,
                        mapImage(thumbnail, imageQuality),
                        resourceURI,
                        comics?.available,
                        mapComics(comics),
                        stories?.available,
                        mapStories(stories),
                        series?.available,
                        mapSeries(series)
                    )
                    heroList.add(hero)
                }
            }

            return heroList
        }

        fun mapImage(image: Image?, imageQuality: ImageQuality): String? {
            if (image == null || image.path.isNullOrEmpty() || image.extension.isNullOrEmpty()) {
                return null
            }

            return image.path + imageQuality.quality + "." + image.extension
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

    enum class ImageQuality(val quality: String) {
        PORTRAIT_SMALL("/portrait_small"),
        PORTRAIT_MEDIUM("/portrait_medium"),
        PORTRAIT_XLARGE("/portrait_xlarge"),
        PORTRAIT_FANTASTIC("/portrait_fantastic"),
        PORTRAIT_UNCANNY("/portrait_uncanny"),
        PORTRAIT_INCREDIBLE("/portrait_incredible"),

        STANDARD_SMALL("/standard_small"),
        STANDARD_MEDIUM("/standard_medium"),
        STANDARD_LARGE("/standard_large"),
        STANDARD_XLARGE("/standard_xlarge"),
        STANDARD_FANTASTIC("/standard_fantastic"),
        STANDARD_AMAZING("/standard_amazing"),

        LANDSCAPE_SMALL("/landscape_small"),
        LANDSCAPE_MEDIUM("/landscape_medium"),
        LANDSCAPE_LARGE("/landscape_large"),
        LANDSCAPE_XLARGE("/landscape_xlarge"),
        LANDSCAPE_AMAZING("/landscape_amazing"),
        LANDSCAPE_INCREDIBLE("/landscape_incredible"),
    }

}