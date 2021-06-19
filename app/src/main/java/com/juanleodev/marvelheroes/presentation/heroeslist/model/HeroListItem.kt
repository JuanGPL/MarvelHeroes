package com.juanleodev.marvelheroes.presentation.heroeslist.model

data class HeroListItem(
    val id: Int,
    val name: String,
    val thumbnail: String? = null
)
