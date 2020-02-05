package com.wild.luxury.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.adapters.CatalogAdapter
import com.wild.luxury.adapters.OnItemClickListener
import com.wild.luxury.R

class Catalog : AppCompatActivity(),
    OnItemClickListener {

    private lateinit var adapter: CatalogAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val items: ArrayList<String> = ArrayList()

        for (i in 1..10) {
            items.add("Name $i")
        }
        val usersList = findViewById<RecyclerView>(R.id.catalogRecView)
        usersList.layoutManager = LinearLayoutManager(this)
        adapter = CatalogAdapter(items, this)
        usersList.adapter = adapter
    }

    override fun onItemClicked() {
        val intent = Intent(this, ProductDescriprionActivity::class.java)
        startActivity(intent)
    }
}
