package com.juanleodev.marvelheroes.data.web.model.serie

import com.google.gson.annotations.SerializedName

data class SeriesDataWrapper(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("attributionHTML")
    val attributionHTML: String?,
    @SerializedName("data")
    val data: SeriesDataContainer?,
    @SerializedName("etag")
    val etag: String?
)