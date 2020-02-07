package com.wild.luxury.activities.room

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wild.luxury.network.Product
import kotlinx.android.synthetic.main.activity_main_room_item.view.*

class RoomViewHolder(itemView: View, private val clickListener: (Product) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bind(product: Product) {
        Picasso.get().load(product.photoUrl).into(itemView.item_image)
        itemView.item_name.text = product.name
        itemView.item_text_category.text = product.category
        itemView.item_text_count.text = "${product.count} шт."
        itemView.setOnClickListener {
            clickListener(product)
        }
    }
}