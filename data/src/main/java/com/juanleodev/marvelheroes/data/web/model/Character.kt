package com.juanleodev.marvelheroes.data.web.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Character(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("modified")
    val modified: Date? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null,
    @SerializedName("thumbnail")
    val thumbnail: Image? = null,
    @SerializedName("comics")
    val comics: ComicList? = null,
    @SerializedName("stories")
    val stories: StoryList? = null,
    @SerializedName("events")
    val events: EventList? = null,
    @SerializedName("series")
    val series: SeriesList? = null
)