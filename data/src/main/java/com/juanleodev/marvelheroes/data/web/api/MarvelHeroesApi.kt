package com.juanleodev.marvelheroes.data.web.api

import com.juanleodev.marvelheroes.data.web.model.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelHeroesApi {

    @GET("v1/public/characters")
    suspend fun getHeroesList(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("ts") timestamp: Long
    ): Response<CharacterDataWrapper>

    @GET("v1/public/characters/{characterId}")
    suspend fun getHero(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timestamp: Long,
        @Path("characterId") heroId: Int
    ): Response<CharacterDataWrapper>
}