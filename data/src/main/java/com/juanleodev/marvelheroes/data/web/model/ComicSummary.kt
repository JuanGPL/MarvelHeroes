package com.juanleodev.marvelheroes.data.web.model

import com.google.gson.annotations.SerializedName

data class ComicSummary(
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("name")
    val name: String? = null
)
