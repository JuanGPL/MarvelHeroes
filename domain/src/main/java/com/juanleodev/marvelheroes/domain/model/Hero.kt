package com.juanleodev.marvelheroes.domain.model

data class Hero(
    val id: Int?,
    val name: String?,
    val description: String?,
    val image: String?,
    val imageHiRes: String?,
    val resourceUri: String?,
    val comicsAvilable: Int?,
    val comics: List<Comic>?,
    val storiesAvailable: Int?,
    val stories: List<Story>?,
    val seriesAvailable: Int?,
    val series: List<Serie>?
)
