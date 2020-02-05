package com.wild.luxury.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.Product
import com.wild.luxury.R
import kotlinx.android.synthetic.main.activity_main_room_item.view.*

class RoomAdapter: RecyclerView.Adapter<RoomViewHolder>() {

    var list : List<Product> = emptyList()
    set (value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder =
        RoomViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_main_room_item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) =
        holder.bind(list[position].name)
}
class RoomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(name: String) {
        itemView.item_name.text = name
    }
}