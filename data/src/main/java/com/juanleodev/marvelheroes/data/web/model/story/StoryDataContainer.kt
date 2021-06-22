package com.juanleodev.marvelheroes.data.web.model.story

import com.google.gson.annotations.SerializedName

data class StoryDataContainer(
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("results")
    val result: List<Story>?
)
