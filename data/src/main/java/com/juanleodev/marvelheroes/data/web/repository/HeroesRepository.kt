package com.juanleodev.marvelheroes.data.web.repository

import com.juanleodev.marvelheroes.data.web.api.MarvelHeroesApi
import com.juanleodev.marvelheroes.data.web.mapper.HeroesMapper
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource
import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.utils.ErrorHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroesRepository(
    private val api: MarvelHeroesApi,
    private val errorHandler: ErrorHandler,
) : Repository(), HeroesDataSource {

    override suspend fun getHeroes(offset: Int): Resource<List<Hero>> =
        withContext(Dispatchers.IO) {
            val (ts, publicKey, hash) = prepareQuery()

            try {
                val response = api.getHeroesList(ts, publicKey, hash, offset)

                if (response.isSuccessful) {
                    val heroList = HeroesMapper.mapToHeroList(
                        response.body()!!,
                        HeroesMapper.ImageQuality.STANDARD_MEDIUM,
                        HeroesMapper.ImageQuality.LANDSCAPE_INCREDIBLE
                    )
                    return@withContext Resource.Success(heroList)
                } else {
                    return@withContext Resource.Error(errorHandler(response.code(), response.errorBody()))
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }

    override suspend fun getHero(heroId: Int): Resource<Hero> =
        withContext(Dispatchers.IO) {
            val (ts, publicKey, hash) = prepareQuery()

            try {
                val response = api.getHero(heroId, ts, publicKey, hash)

                if (response.isSuccessful) {
                    val heroList = HeroesMapper.mapToHeroList(
                        response.body()!!,
                        HeroesMapper.ImageQuality.LANDSCAPE_INCREDIBLE,
                        HeroesMapper.ImageQuality.PORTRAIT_INCREDIBLE
                    )
                    return@withContext Resource.Success(heroList[0])
                } else {
                    return@withContext Resource.Error(errorHandler(response.code(), response.errorBody()))
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }

}