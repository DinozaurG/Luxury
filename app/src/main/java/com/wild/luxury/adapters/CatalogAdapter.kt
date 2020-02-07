package com.wild.luxury.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.Product
import com.wild.luxury.R
import com.wild.luxury.CatalogViewHolder

class CatalogAdapter(var items: List<Product>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<CatalogViewHolder>() {

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
    fun updateList(newList: List<Product>)
    {
        items = newList
        notifyDataSetChanged()
    }
}

interface OnItemClickListener{
    fun onItemClicked(item: Product)
}