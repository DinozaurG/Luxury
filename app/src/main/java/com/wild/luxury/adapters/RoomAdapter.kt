package com.wild.luxury.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.Product
import com.wild.luxury.R
import kotlinx.android.synthetic.main.activity_main_room_item.view.*
import kotlinx.android.synthetic.main.activity_main_room_item_image.view.*

class RoomAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list : List<Product> = emptyList()
    set (value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            RoomViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_main_room_item, parent, false))
        } else {
            ImageViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_main_room_item_image, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int = if (position != 0) 0 else 1

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return if (holder.itemViewType == 0) {
            (holder as RoomViewHolder).bind(list[position-1])
        } else {
            (holder as ImageViewHolder).bind()
        }
    }
}
class RoomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(product: Product) {
        itemView.item_name.text = product.name
    }
}
class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind() {
        itemView.roomImage.setImageResource(R.drawable.econom_hotel_room)
    }
}
