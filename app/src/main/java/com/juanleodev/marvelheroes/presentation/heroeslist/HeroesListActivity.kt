package com.juanleodev.marvelheroes.presentation.heroeslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juanleodev.marvelheroes.R

class HeroesListActivity : AppCompatActivity() {

//    private val viewModel by viewModel<HeroesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes_list)

    }
}