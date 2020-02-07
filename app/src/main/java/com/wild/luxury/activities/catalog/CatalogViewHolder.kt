package com.wild.luxury.activities.catalog

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wild.luxury.network.Product
import kotlinx.android.synthetic.main.catalog_row.view.*

class CatalogViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item : Product, clickListener: OnItemClickListener) {
        Picasso.get().load(item.photoUrl).into(itemView.item_image)
        itemView.item_name.text = item.name
        itemView.item_text_category.text = item.category
        itemView.item_text_count.text = "${item.price} руб."
        itemView.setOnClickListener {
            clickListener.onItemClicked(item)
        }
    }
}