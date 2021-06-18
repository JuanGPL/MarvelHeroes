package com.juanleodev.marvelheroes.data.web

import com.juanleodev.marvelheroes.data.BuildConfig
import com.juanleodev.marvelheroes.data.web.api.MarvelHeroesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMarvelHeroesApi(): MarvelHeroesApi = retrofitInstance.create(MarvelHeroesApi::class.java)

}