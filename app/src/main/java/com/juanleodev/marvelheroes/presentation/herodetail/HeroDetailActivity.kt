package com.juanleodev.marvelheroes.presentation.herodetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.juanleodev.marvelheroes.BuildConfig
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.databinding.ActivityHeroDetailBinding
import com.juanleodev.marvelheroes.domain.error.ErrorEntity
import com.juanleodev.marvelheroes.presentation.common.LoadingDialog
import com.juanleodev.marvelheroes.presentation.common.SnackbarHelper
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

        viewModel.getLoadingObservable().observe(this, {
            LoadingDialog.show(this, it)
        })

        viewModel.getErrorObservable().observe(this, {
            SnackbarHelper.showSnackbar(
                this,
                binding.root,
                mapError(it),
                SnackbarHelper.Type.ERROR,
                R.string.ok
            )
        })
    }

    private fun checkDescriptionContent(content: String?): String {
        if (content.isNullOrEmpty()) {
            return getString(R.string.no_description)
        }

        return content
    }

    private fun mapError(error: ErrorEntity): String {
        return when(error) {
            ErrorEntity.Network -> getString(R.string.error_network)
            ErrorEntity.NotFound -> getString(R.string.error_not_found)
            ErrorEntity.ServiceUnavailable -> getString(R.string.error_service_unavailable)
            ErrorEntity.Unknown -> getString(R.string.error_unknown)
            else -> error.message ?: getString(R.string.error_unknown)
        }
    }
}