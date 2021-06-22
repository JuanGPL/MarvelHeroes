package com.juanleodev.marvelheroes.data.web.model.story

import com.google.gson.annotations.SerializedName

data class Story(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String?
)
