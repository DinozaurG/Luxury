package com.wild.luxury

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_catalog.*

class Catalog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val items: ArrayList<String> = ArrayList()

        for(i in 1..10)
        {
            items.add("Name $i")
        }
        catalogRecView.layoutManager = LinearLayoutManager(this)
        catalogRecView.adapter = CatalogAdapter(items)
    }
}
