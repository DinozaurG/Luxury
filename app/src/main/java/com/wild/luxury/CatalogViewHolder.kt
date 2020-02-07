package com.wild.luxury

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.adapters.OnItemClickListener

class CatalogViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val img: ImageView = itemView.findViewById(R.id.imageOfTovar)
    val price: TextView = itemView.findViewById(R.id.priceOfTovar)
    val desc: TextView = itemView.findViewById(R.id.describeOfTovar)
    val nme: TextView = itemView.findViewById(R.id.nameOfTovar)
    fun bind(item : Product, clickListener: OnItemClickListener)
    {
        itemView.setOnClickListener {
            clickListener.onItemClicked(item)
        }
    }
}