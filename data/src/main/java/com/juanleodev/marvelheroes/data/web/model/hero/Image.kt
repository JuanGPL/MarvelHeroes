package com.juanleodev.marvelheroes.data.web.model.hero

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("path")
    val path: String? = null,
    @SerializedName("extension")
    val extension: String? = null
)
