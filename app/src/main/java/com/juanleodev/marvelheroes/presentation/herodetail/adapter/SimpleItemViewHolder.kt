package com.juanleodev.marvelheroes.presentation.herodetail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.juanleodev.marvelheroes.databinding.ItemSimpleBinding

class SimpleItemViewHolder(private val itemBinding: ItemSimpleBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(itemList: String) {
        itemBinding.tvSimpleItem.text = itemList
    }

}