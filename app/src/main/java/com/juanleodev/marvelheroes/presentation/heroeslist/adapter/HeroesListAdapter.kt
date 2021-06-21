package com.juanleodev.marvelheroes.presentation.heroeslist.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.juanleodev.marvelheroes.BuildConfig
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.presentation.herodetail.HeroDetailActivity
import com.juanleodev.marvelheroes.presentation.heroeslist.model.HeroListItem

class HeroesListAdapter(
    private val context: Activity
) : RecyclerView.Adapter<HeroesListAdapter.ViewHolder>() {

    private var itemList: List<HeroListItem> = ArrayList()

    fun setItemList(itemList: List<HeroListItem>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setHeroItem(itemList[position])
        holder.itemView.setOnClickListener {
            if (itemHasContent(itemList[position])) {
                val heroId = itemList[position].id
                val detailHeroIntent = Intent(context, HeroDetailActivity::class.java)
                detailHeroIntent.putExtra(BuildConfig.EXTRA_HERO_ID, heroId)
                context.startActivity(detailHeroIntent)
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun itemHasContent(heroListItem: HeroListItem): Boolean {
        return !((heroListItem.thumbnail == null || heroListItem.thumbnail.contains("image_not_available")) &&
                heroListItem.description.isNullOrEmpty())
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgBackground = view.findViewById<ImageView>(R.id.imgCardBackground)
        private val imgHeroThumb = view.findViewById<ImageView>(R.id.imgHeroThumbnail)
        private val tvHeroName = view.findViewById<TextView>(R.id.tvHeroName)
        private val tvTotalComics = view.findViewById<TextView>(R.id.tvTotalComics)
        private val tvTotalSeries = view.findViewById<TextView>(R.id.tvTotalSeries)
        private val tvTotalStories = view.findViewById<TextView>(R.id.tvTotalStories)
        private val imgChevron = view.findViewById<ImageView>(R.id.imgChevron)
        private val tvComingSoon = view.findViewById<TextView>(R.id.tvComingSoon)

        fun setHeroItem(heroListItem: HeroListItem) {
            setComingSoon(heroListItem)

            with(heroListItem) {
                tvHeroName.text = name
                tvTotalComics.text = totalComics.toString()
                tvTotalSeries.text = totalSeries.toString()
                tvTotalStories.text = totalStories.toString()
                Glide.with(context)
                    .load(imageHiRes ?: R.drawable.ic_launcher_background)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgBackground)
                Glide.with(context)
                    .load(thumbnail ?: R.drawable.ic_launcher_background)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgHeroThumb)
            }
        }

        private fun setComingSoon(heroListItem: HeroListItem) {
            if (itemHasContent(heroListItem)) {
                imgChevron.visibility = View.VISIBLE
                tvComingSoon.visibility = View.GONE
            } else {
                imgChevron.visibility = View.GONE
                tvComingSoon.visibility = View.VISIBLE
            }
        }
    }
}