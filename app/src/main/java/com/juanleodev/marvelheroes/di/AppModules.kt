package com.juanleodev.marvelheroes.di

import com.juanleodev.marvelheroes.data.web.RestClient
import com.juanleodev.marvelheroes.data.web.repository.HeroesRepository
import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource
import com.juanleodev.marvelheroes.domain.usecase.*
import com.juanleodev.marvelheroes.presentation.herodetail.HeroDetailViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.comics.ComicsViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.comics.mapper.ComicListMapper
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.series.SeriesViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.series.mapper.SerieListMapper
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.stories.StoriesViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.stories.mapper.StoryListMapper
import com.juanleodev.marvelheroes.presentation.herodetail.mapper.HeroDetailMapper
import com.juanleodev.marvelheroes.presentation.heroeslist.HeroesListViewModel
import com.juanleodev.marvelheroes.presentation.heroeslist.mapper.HeroesListMapper
import com.juanleodev.marvelheroes.utils.ErrorHandler
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HeroesListViewModel(get(), get()) }
    single { HeroesListMapper() }

    viewModel { HeroDetailViewModel(get(), get()) }
    single { HeroDetailMapper() }

    viewModel { ComicsViewModel(get(), get()) }
    single { ComicListMapper() }

    viewModel { SeriesViewModel(get(), get()) }
    single { SerieListMapper() }

    viewModel { StoriesViewModel(get(), get()) }
    single { StoryListMapper() }
}

val domainModule = module {
    single { GetHeroes(get()) }
    single { GetHero(get()) }
    single { GetComics(get()) }
    single { GetSeries(get()) }
    single { GetStories(get()) }
}

val dataModule = module {
    single<HeroesDataSource> { HeroesRepository(get(), get()) }
    single { RestClient.getMarvelHeroesApi() }
    single { ErrorHandler() }
}