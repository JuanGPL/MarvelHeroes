package com.juanleodev.marvelheroes.presentation.herodetail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.juanleodev.marvelheroes.R

class SimpleListAdapter(
    private val itemList: List<String>
) : RecyclerView.Adapter<SimpleListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text = itemList[position]
    }

    override fun getItemCount(): Int = itemList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemText: TextView = view.findViewById(R.id.tvSimpleItem)
    }
}