package com.juanleodev.marvelheroes.data.web.model.hero

import com.google.gson.annotations.SerializedName

data class CharacterDataContainer(
    @SerializedName("offset")
    val offset: Int? = null,
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("results")
    val results: List<Character>? = null
)
