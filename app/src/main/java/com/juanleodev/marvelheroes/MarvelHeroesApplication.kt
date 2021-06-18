package com.juanleodev.marvelheroes

import android.app.Application
import com.juanleodev.marvelheroes.di.dataModule
import com.juanleodev.marvelheroes.di.domainModule
import com.juanleodev.marvelheroes.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MarvelHeroesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MarvelHeroesApplication)
            modules(
                viewModelModule,
                domainModule,
                dataModule
            )
        }
    }

}