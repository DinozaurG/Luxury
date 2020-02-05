package com.wild.luxury.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.Product
import com.wild.luxury.R

class CatalogAdapter(val items: ArrayList<Product>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.catalog_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Product = items[position]
        holder.nme.text = items[position].name
        holder.price.text = items[position].price.toString()
        holder.desc.text = items[position].descriptor
        holder.bind(item, itemClickListener)

    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        //val img: ImageView = itemView.findViewById(R.id.imageOfTovar)
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
}

interface OnItemClickListener{
    fun onItemClicked(item: Product)
}