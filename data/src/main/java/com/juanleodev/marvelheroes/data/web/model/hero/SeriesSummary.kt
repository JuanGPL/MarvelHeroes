package com.juanleodev.marvelheroes.data.web.model.hero

import com.google.gson.annotations.SerializedName

data class SeriesSummary(
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("name")
    val name: String? = null
)
