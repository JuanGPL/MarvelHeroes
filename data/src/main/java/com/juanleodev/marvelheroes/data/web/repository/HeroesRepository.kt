package com.juanleodev.marvelheroes.data.web.repository

import com.juanleodev.marvelheroes.data.web.api.MarvelHeroesApi
import com.juanleodev.marvelheroes.data.web.mapper.ComicsMapper
import com.juanleodev.marvelheroes.data.web.mapper.HeroesMapper
import com.juanleodev.marvelheroes.data.web.mapper.SeriesMapper
import com.juanleodev.marvelheroes.data.web.mapper.StoriesMapper
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource
import com.juanleodev.marvelheroes.domain.model.Comic
import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.domain.model.Serie
import com.juanleodev.marvelheroes.domain.model.Story
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

    override suspend fun getComics(heroId: Int, offset: Int): Resource<List<Comic>> =
        withContext(Dispatchers.IO) {
            val (ts, publicKey, hash) = prepareQuery()

            try {
                val response = api.getComics(heroId, ts, publicKey, hash, offset)

                if (response.isSuccessful) {
                    val comicList = ComicsMapper.mapToComic(response.body()!!)
                    return@withContext Resource.Success(comicList)
                } else {
                    return@withContext Resource.Error(errorHandler(response.code(), response.errorBody()))
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }

    override suspend fun getSeries(heroId: Int, offset: Int): Resource<List<Serie>> =
        withContext(Dispatchers.IO) {
            val (ts, publicKey, hash) = prepareQuery()

            try {
                val response = api.getSeries(heroId, ts, publicKey, hash, offset)

                if (response.isSuccessful) {
                    val serieList = SeriesMapper.mapToSeries(response.body()!!)
                    return@withContext Resource.Success(serieList)
                } else {
                    return@withContext Resource.Error(errorHandler(response.code(), response.errorBody()))
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }

    override suspend fun getStories(heroId: Int, offset: Int): Resource<List<Story>> =
        withContext(Dispatchers.IO) {
            val (ts, publicKey, hash) = prepareQuery()

            try {
                val response = api.getStories(heroId, ts, publicKey, hash, offset)

                if (response.isSuccessful) {
                    val storyList = StoriesMapper.mapToStories(response.body()!!)
                    return@withContext Resource.Success(storyList)
                } else {
                    return@withContext Resource.Error(errorHandler(response.code(), response.errorBody()))
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }

}