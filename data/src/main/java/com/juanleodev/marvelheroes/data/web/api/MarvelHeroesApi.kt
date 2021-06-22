package com.juanleodev.marvelheroes.data.web.api

import com.juanleodev.marvelheroes.data.web.model.comic.ComicDataWrapper
import com.juanleodev.marvelheroes.data.web.model.hero.CharacterDataWrapper
import com.juanleodev.marvelheroes.data.web.model.serie.SeriesDataWrapper
import com.juanleodev.marvelheroes.data.web.model.story.StoryDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface MarvelHeroesApi {

    @GET("v1/public/characters")
    suspend fun getHeroesList(
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int
    ): Response<CharacterDataWrapper>

    @GET("v1/public/characters/{characterId}")
    suspend fun getHero(
        @Path("characterId") heroId: Int,
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<CharacterDataWrapper>

    @GET("v1/public/characters/{characterId}/comics")
    suspend fun getComics(
        @Path("characterId") heroId: Int,
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int
    ): Response<ComicDataWrapper>

    @GET("v1/public/characters/{characterId}/series")
    suspend fun getSeries(
        @Path("characterId") heroId: Int,
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int
    ): Response<SeriesDataWrapper>

    @GET("v1/public/characters/{characterId}/stories")
    suspend fun getStories(
        @Path("characterId") heroId: Int,
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int
    ): Response<StoryDataWrapper>
}

