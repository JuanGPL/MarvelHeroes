package com.juanleodev.marvelheroes.presentation.heroeslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juanleodev.marvelheroes.databinding.ActivityHeroesListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesListBinding

    private val viewModel by viewModel<HeroesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        observeStatus()

        viewModel.getHeroesList()
    }

    private fun initViews() {
        initHeroesRecycler()
    }

    private fun initHeroesRecycler() {
        with(binding.recyclerHeroes) {
            layoutManager = LinearLayoutManager(this@HeroesListActivity)

            val heroesAdapter = HeroesListAdapter(this@HeroesListActivity)
            adapter = heroesAdapter
        }
    }

    private fun observeStatus() {
        viewModel.getHeroesListObservable().observe(this, {
            (binding.recyclerHeroes.adapter as HeroesListAdapter).setItemList(it)
            setRecyclerViewScrollListener()
        })
    }

    private fun setRecyclerViewScrollListener() {
        with(binding.recyclerHeroes) {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if ((layoutManager as LinearLayoutManager).findLastVisibleItemPosition() == (adapter as HeroesListAdapter).itemCount - 1) {
                        viewModel.getHeroesList()
                        removeOnScrollListener(this)
                    }
                }
            })
        }
    }
}