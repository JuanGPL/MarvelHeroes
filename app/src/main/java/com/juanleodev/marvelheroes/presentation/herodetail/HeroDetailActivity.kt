package com.juanleodev.marvelheroes.presentation.herodetail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.juanleodev.marvelheroes.BuildConfig
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.databinding.ActivityHeroDetailBinding
import com.juanleodev.marvelheroes.presentation.common.BaseActivity
import com.juanleodev.marvelheroes.presentation.herodetail.adapter.HeroDetailVPAdapter
import com.juanleodev.marvelheroes.presentation.herodetail.model.HeroDetail
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroDetailActivity : BaseActivity() {

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
        super.observeStatus(viewModel, binding.root)

        viewModel.getHeroDetailObservable().observe(this, {
            if (it == null) {
                viewModel.showGeneralError()
            } else {
                initViews(it)
            }
        })
    }

    private fun initViews(heroDetail: HeroDetail) {
        initHeroName(heroDetail)
        initHeroImage(heroDetail)
        initViewPager(heroDetail)
        connectTabLayoutAndViewPager()
    }

    private fun initHeroName(heroDetail: HeroDetail) {
        binding.tvHeroNameDetail.text = heroDetail.name
    }

    private fun initHeroImage(heroDetail: HeroDetail) {
        Glide.with(this@HeroDetailActivity)
            .load(heroDetail.image ?: R.drawable.ic_launcher_background)
            .into(binding.imgHeroDetail)
    }

    private fun initViewPager(heroDetail: HeroDetail) {
        binding.viewPagerDetail.adapter =
            HeroDetailVPAdapter(supportFragmentManager, lifecycle, heroDetail)
    }

    private fun connectTabLayoutAndViewPager() {
        TabLayoutMediator(binding.tabLayoutDetail, binding.viewPagerDetail) { tab, position ->
            when (position) {
                0 -> tab.text = getText(R.string.description)
                1 -> tab.text = getText(R.string.comics)
                2 -> tab.text = getText(R.string.series)
                3 -> tab.text = getText(R.string.stories)
            }
        }.attach()
    }
}