package com.wild.luxury.activities.catalog

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.R
import com.wild.luxury.network.Product

class CatalogViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    //val img: ImageView = itemView.findViewById(R.id.imageOfTovar)
    val price: TextView = itemView.findViewById(R.id.priceOfTovar)
    val desc: TextView = itemView.findViewById(R.id.describeOfTovar)
    val nme: TextView = itemView.findViewById(R.id.nameOfTovar)
    fun bind(item : Product, clickListener: OnItemClickListener) {
        itemView.setOnClickListener {
            clickListener.onItemClicked(item)
        }
    }
}