package com.juanleodev.marvelheroes.presentation.heroeslist.mapper

import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.presentation.heroeslist.model.HeroListItem

class HeroesListMapper {

    operator fun invoke(heroList: List<Hero>): List<HeroListItem> {
        val heroItemList: ArrayList<HeroListItem> = ArrayList()

        heroList.forEach {
            with(it) {
                val itemId = id ?: -1
                val itemName = name
                val totalComics = comicsAvilable ?: 0
                val totalStories = storiesAvailable ?: 0
                val totalSeries = seriesAvailable ?: 0

                if (itemId != -1 && itemName != null) {
                    val item = HeroListItem(
                        itemId,
                        itemName,
                        description,
                        image,
                        imageHiRes,
                        totalComics,
                        totalStories,
                        totalSeries)
                    heroItemList.add(item)
                }
            }
        }

        return heroItemList
    }

}