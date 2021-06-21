package com.juanleodev.marvelheroes.domain.model

data class Hero(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val image: String? = null,
    val imageHiRes: String? = null,
    val resourceUri: String? = null,
    val comicsAvilable: Int? = null,
    val comics: List<Comic>? = null,
    val storiesAvailable: Int? = null,
    val stories: List<Story>? = null,
    val seriesAvailable: Int? = null,
    val series: List<Serie>? = null
)
