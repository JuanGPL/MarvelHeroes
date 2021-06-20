package com.juanleodev.marvelheroes.presentation.heroeslist

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
            val heroId = itemList[position].id
            val detailHeroIntent = Intent(context, HeroDetailActivity::class.java)
            detailHeroIntent.putExtra(BuildConfig.EXTRA_HERO_ID, heroId)
            context.startActivity(detailHeroIntent)
        }
    }

    override fun getItemCount(): Int = itemList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvHeroName = view.findViewById<TextView>(R.id.tvHeroName)
        private val imgHeroThumb = view.findViewById<ImageView>(R.id.imgHeroThumbnail)

        fun setHeroItem(heroListItem: HeroListItem) {
            tvHeroName.text = heroListItem.name
            Glide.with(context)
                .load(heroListItem.thumbnail ?: R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgHeroThumb)
        }
    }
}