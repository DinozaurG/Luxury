package com.wild.luxury.activities.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.network.Product
import com.wild.luxury.R

class CatalogAdapter(var items: MutableList<Product>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<CatalogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.catalog_row, parent, false)
        return CatalogViewHolder(view)
    }
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val item : Product = items[position]
        holder.nme.text = items[position].name
        holder.price.text = items[position].price.toString()
        holder.desc.text = items[position].description
        holder.bind(item, itemClickListener)

    }

    fun updateList(newList: MutableList<Product>) {
        items = newList
        notifyDataSetChanged()
    }
}
interface OnItemClickListener {
    fun onItemClicked(item: Product)
}