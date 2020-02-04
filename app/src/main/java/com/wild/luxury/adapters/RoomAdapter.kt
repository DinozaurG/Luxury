package com.wild.luxury.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RoomAdapter: RecyclerView.Adapter<RoomViewHolder>() {

    var list : List<String> = emptyList()
    set (value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder =
        LayoutInflater.from(parent.context)
            .inflate()

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) =
        holder.bind()
}
class RoomViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(parent.) {
    fun bind()
}