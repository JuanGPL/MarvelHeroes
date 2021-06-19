package com.juanleodev.marvelheroes.presentation.heroeslist

import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.presentation.heroeslist.model.HeroListItem

class HeroesListMapper {

    operator fun invoke(heroList: List<Hero>): List<HeroListItem> {
        val heroItemList: ArrayList<HeroListItem> = ArrayList()

        heroList.forEach {
            with(it) {
                val itemId = id ?: -1
                val itemName = name ?: "Personaje sin nombre"
                val item = HeroListItem(itemId, itemName, image)
                heroItemList.add(item)
            }
        }

        return heroItemList
    }

}