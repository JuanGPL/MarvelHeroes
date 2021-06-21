package com.juanleodev.marvelheroes.presentation.herodetail.model

data class HeroDetail(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val image: String? = null,
    val comics: List<String>? = null,
    val series: List<String>? = null,
    val stories: List<String>? = null
)
