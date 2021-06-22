package com.juanleodev.marvelheroes.presentation.heroeslist.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juanleodev.marvelheroes.databinding.ItemHeroBinding
import com.juanleodev.marvelheroes.presentation.heroeslist.model.HeroListItem

class HeroesListAdapter(
    private val context: Activity
) : RecyclerView.Adapter<HeroeItemViewHolder>() {

    private var itemList: List<HeroListItem> = ArrayList()

    fun setItemList(itemList: List<HeroListItem>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeItemViewHolder {
        return HeroeItemViewHolder(
            ItemHeroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            context
        )
    }

    override fun onBindViewHolder(holder: HeroeItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size


}