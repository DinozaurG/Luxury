package com.wild.luxury.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.Product
import com.wild.luxury.R
import com.wild.luxury.ViewHolder

class CatalogAdapter(var items: List<Product>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.catalog_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Product = items[position]
        holder.nme.text = items[position].name
        holder.price.text = items[position].price.toString()
        holder.desc.text = items[position].description
        holder.bind(item, itemClickListener)
    }
    fun updateList(newList: List<Product> )
    {
        items = newList
        notifyDataSetChanged()
    }
}

interface OnItemClickListener{
    fun onItemClicked(item: Product)
}