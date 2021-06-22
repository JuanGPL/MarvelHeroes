package com.juanleodev.marvelheroes.data.web.model.serie

import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String?
)
