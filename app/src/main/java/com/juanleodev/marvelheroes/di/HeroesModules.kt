package com.juanleodev.marvelheroes.di

import com.juanleodev.marvelheroes.presentation.herodetail.HeroDetailViewModel
import com.juanleodev.marvelheroes.presentation.heroeslist.HeroesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val heroesModule = module {
    viewModel { HeroesListViewModel(get()) }
    viewModel { HeroDetailViewModel(get()) }
}