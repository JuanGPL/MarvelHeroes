package com.juanleodev.marvelheroes.data.web.model.comic

import com.google.gson.annotations.SerializedName

data class Comic(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String?
)
