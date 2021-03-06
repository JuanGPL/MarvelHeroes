package com.juanleodev.marvelheroes.presentation.herodetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.comics.ComicsFragment
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.description.DescriptionFragment
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.series.SeriesFragment
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.stories.StoriesFragment
import com.juanleodev.marvelheroes.presentation.herodetail.model.HeroDetail

class HeroDetailVPAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle,
    private val heroDetail: HeroDetail
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DescriptionFragment(heroDetail.description)
            1 -> ComicsFragment(heroDetail.id)
            2 -> SeriesFragment(heroDetail.id)
            3 -> StoriesFragment(heroDetail.id)
            else -> DescriptionFragment(heroDetail.description)
        }
    }

}