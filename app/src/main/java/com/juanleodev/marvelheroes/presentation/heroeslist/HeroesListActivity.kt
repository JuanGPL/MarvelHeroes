package com.juanleodev.marvelheroes.presentation.heroeslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juanleodev.marvelheroes.databinding.ActivityHeroesListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesListBinding

    private val viewModel by viewModel<HeroesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testButton.setOnClickListener {
            println("hola")
            viewModel.getHeroesList()
        }

        viewModel.getHeroesList()
    }
}