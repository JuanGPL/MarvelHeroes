package com.juanleodev.marvelheroes.presentation.heroeslist.model

data class HeroListItem(
    val id: Int,
    val name: String?,
    val description: String?,
    val thumbnail: String? = null,
    val imageHiRes: String? = null,
    val totalComics: Int = 0,
    val totalStories: Int = 0,
    val totalSeries: Int = 0
)
