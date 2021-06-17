package com.juanleodev.marvelheroes.data.web.model

import com.google.gson.annotations.SerializedName

data class StorySummary(
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null
)
