package com.juanleodev.marvelheroes.domain.model

data class Hero(
    val id: Int?,
    val name: String?,
    val description: String?,
    val image: String?,
    val resourceUri: String?,
    val comics: List<Comic>?,
    val stories: List<Story>?,
    val series: List<Serie>?
)
