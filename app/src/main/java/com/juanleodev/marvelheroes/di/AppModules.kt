package com.juanleodev.marvelheroes.di

import com.juanleodev.marvelheroes.data.web.RestClient
import com.juanleodev.marvelheroes.data.web.repository.HeroesRepository
import com.juanleodev.marvelheroes.domain.boundary.HeroesDataSource
import com.juanleodev.marvelheroes.domain.usecase.GetHero
import com.juanleodev.marvelheroes.domain.usecase.GetHeroes
import com.juanleodev.marvelheroes.presentation.herodetail.HeroDetailViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.mapper.HeroDetailMapper
import com.juanleodev.marvelheroes.presentation.heroeslist.HeroesListViewModel
import com.juanleodev.marvelheroes.presentation.heroeslist.mapper.HeroesListMapper
import com.juanleodev.marvelheroes.utils.ErrorHandler
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HeroesListViewModel(get(), get()) }
    viewModel { HeroDetailViewModel(get(), get()) }
    single { HeroesListMapper() }
    single { HeroDetailMapper() }
}

val domainModule = module {
    single { GetHeroes(get()) }
    single { GetHero(get()) }
}

val dataModule = module {
    single<HeroesDataSource> { HeroesRepository(get(), get()) }
    single { RestClient.getMarvelHeroesApi() }
    single { ErrorHandler() }
}