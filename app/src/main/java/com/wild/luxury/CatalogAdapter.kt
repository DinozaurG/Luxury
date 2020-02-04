package com.wild.luxury

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatalogAdapter(val items: ArrayList<String>): RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.catalog_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nme.text = items[position]

    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        /*val img: TextView = itemView.findViewById(R.id.imageOfTovar)
        val price: TextView = itemView.findViewById(R.id.priceOfTovar)
        val desc: TextView = itemView.findViewById(R.id.describeOfTovar)*/
        val nme: TextView = itemView.findViewById(R.id.nameOfTovar)
    }
}