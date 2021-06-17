package com.juanleodev.marvelheroes.data.web.model

import com.google.gson.annotations.SerializedName

data class SeriesList(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("returned")
    val returned: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<SeriesSummary>? = null
)
