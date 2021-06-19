package com.juanleodev.marvelheroes.data.web.repository

import com.juanleodev.marvelheroes.data.web.api.MarvelHeroesApi
import com.juanleodev.marvelheroes.data.web.mapper.HeroesMapper
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource
import com.juanleodev.marvelheroes.domain.model.Hero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroesRepository(
    private val api: MarvelHeroesApi
) : Repository(), HeroesDataSource {

    override suspend fun getHeroes(offset: Int): Resource<List<Hero>> =
        withContext(Dispatchers.IO) {
            val (ts, publicKey, hash) = prepareQuery()

            try {
                val response = api.getHeroesList(ts, publicKey, hash, offset)

                if (response.isSuccessful) {
                    if (response.body() != null) {
                        val heroList = HeroesMapper.mapToHeroList(response.body()!!, HeroesMapper.ImageQuality.STANDARD_MEDIUM)
                        return@withContext Resource.Success(heroList)
                    } else {
                        return@withContext Resource.Error(nullResponseBodyException())
                    }
                } else {
                    return@withContext Resource.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(e)
            }
        }

    override suspend fun getHero(heroId: Int): Resource<Hero> =
        withContext(Dispatchers.IO) {
            val (ts, publicKey, hash) = prepareQuery()

            try {
                val response = api.getHero(ts, publicKey, hash, heroId)

                if (response.isSuccessful) {
                    if (response.body() != null) {
                        val heroList = HeroesMapper.mapToHeroList(response.body()!!, HeroesMapper.ImageQuality.LANDSCAPE_XLARGE)
                        return@withContext Resource.Success(heroList[0])
                    } else {
                        return@withContext Resource.Error(nullResponseBodyException())
                    }
                } else {
                    return@withContext Resource.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(e)
            }
        }

}