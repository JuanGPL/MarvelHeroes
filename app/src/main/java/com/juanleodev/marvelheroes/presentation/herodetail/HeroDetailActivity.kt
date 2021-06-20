package com.juanleodev.marvelheroes.presentation.herodetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.juanleodev.marvelheroes.BuildConfig
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.databinding.ActivityHeroDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroDetailBinding

    private val viewModel by viewModel<HeroDetailViewModel>()

    private var heroId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtras()
        observeStatus()

        viewModel.getHeroDetail(heroId)
    }

    private fun getExtras() {
        heroId = intent.extras?.getInt(BuildConfig.EXTRA_HERO_ID, 0)!!
    }

    private fun observeStatus() {
        viewModel.getHeroDetailObservable().observe(this, {
            with(binding) {
                Glide.with(this@HeroDetailActivity)
                    .load(it.image)
                    .into(imgHeroDetail)

                tvHeroNameDetail.text = it.name
                tvHeroDescription.text = checkDescriptionContent(it.description)
            }
        })
    }

    private fun checkDescriptionContent(content: String?): String {
        if (content.isNullOrEmpty()) {
            return getString(R.string.no_description)
        }

        return content
    }
}