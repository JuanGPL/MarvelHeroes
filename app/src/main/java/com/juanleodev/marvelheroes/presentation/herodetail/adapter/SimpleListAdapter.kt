package com.juanleodev.marvelheroes.presentation.herodetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juanleodev.marvelheroes.databinding.ItemSimpleBinding

class SimpleListAdapter : RecyclerView.Adapter<SimpleItemViewHolder>() {

    private var itemList: List<String> = ArrayList()

    fun setItems(items: List<String>) {
        itemList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleItemViewHolder {
        return SimpleItemViewHolder(
            ItemSimpleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SimpleItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}