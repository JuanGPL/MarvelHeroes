package com.juanleodev.marvelheroes.data.web.model.serie

import com.google.gson.annotations.SerializedName

data class SeriesDataContainer(
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("results")
    val result: List<Series>?
)
