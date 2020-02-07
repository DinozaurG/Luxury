package com.wild.luxury.activities.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.network.Product
import com.wild.luxury.R
import kotlinx.android.synthetic.main.activity_main_room_item_image.view.*

class RoomAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var name: String = ""
    var roomType: String = ""
    var roomArea: String = ""
    var maxProduct: String = ""
    var productCount: String = ""

    var list : List<Product> = emptyList()
    set (value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            RoomViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_main_room_item, parent, false)
            )
        } else {
            ImageViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_main_room_item_image, parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int = if (position != 0) 0 else 1

    override fun getItemCount(): Int = list.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return if (holder.itemViewType == 0) {
            (holder as RoomViewHolder).bind(list[position-1])
        } else {
            (holder as ImageViewHolder).bind(
                name,
                roomType,
                roomArea,
                maxProduct,
                productCount
            )
        }
    }
}