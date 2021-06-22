package com.juanleodev.marvelheroes.presentation.heroeslist.adapter

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.juanleodev.marvelheroes.BuildConfig
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.databinding.ItemHeroBinding
import com.juanleodev.marvelheroes.presentation.herodetail.HeroDetailActivity
import com.juanleodev.marvelheroes.presentation.heroeslist.model.HeroListItem

class HeroeItemViewHolder(
    private val itemBinding: ItemHeroBinding,
    private val context: Activity) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(heroListItem: HeroListItem) {
        setComingSoon(heroListItem)

        with(itemBinding) {
            tvHeroName.text = heroListItem.name
            tvTotalComics.text = heroListItem.totalComics.toString()
            tvTotalSeries.text = heroListItem.totalSeries.toString()
            tvTotalStories.text = heroListItem.totalStories.toString()

            Glide.with(context)
                .load(heroListItem.imageHiRes ?: R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgCardBackground)
            Glide.with(context)
                .load(heroListItem.thumbnail ?: R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgHeroThumbnail)

            setOnClickItem(heroListItem)
        }
    }

    private fun setComingSoon(heroListItem: HeroListItem) {
        with(itemBinding) {
            if (itemHasContent(heroListItem)) {
                imgChevron.visibility = View.VISIBLE
                tvComingSoon.visibility = View.GONE
            } else {
                imgChevron.visibility = View.GONE
                tvComingSoon.visibility = View.VISIBLE
            }
        }
    }

    private fun itemHasContent(heroListItem: HeroListItem): Boolean {
        return !((heroListItem.thumbnail == null || heroListItem.thumbnail.contains("image_not_available")) &&
                heroListItem.description.isNullOrEmpty())
    }

    private fun setOnClickItem(heroListItem: HeroListItem) {
        itemView.setOnClickListener {
            if (itemHasContent(heroListItem)) {
                val heroId = heroListItem.id
                val detailHeroIntent = Intent(context, HeroDetailActivity::class.java)
                detailHeroIntent.putExtra(BuildConfig.EXTRA_HERO_ID, heroId)
                context.startActivity(detailHeroIntent)
            }
        }
    }
}