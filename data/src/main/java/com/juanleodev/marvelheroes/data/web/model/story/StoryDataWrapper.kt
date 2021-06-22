package com.juanleodev.marvelheroes.data.web.model.story

import com.google.gson.annotations.SerializedName

data class StoryDataWrapper(
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
    val data: StoryDataContainer?,
    @SerializedName("etag")
    val etag: String?
)
