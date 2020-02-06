package com.wild.luxury.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.CatalogList
import com.wild.luxury.Product
import com.wild.luxury.adapters.CatalogAdapter
import com.wild.luxury.adapters.OnItemClickListener
import com.wild.luxury.R
import com.wild.luxury.network.App
import kotlinx.android.synthetic.main.activity_catalog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Catalog : AppCompatActivity(),
    OnItemClickListener {

    private lateinit var adapter: CatalogAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val items = getProducts(this)

        val itemsList = findViewById<RecyclerView>(R.id.catalogRecView)
//        itemsList.layoutManager = LinearLayoutManager(this)
//        adapter = CatalogAdapter(items, this)
//        itemsList.adapter = adapter
    }

    override fun onItemClicked(item: Product) {
        val intent = Intent(this, ProductDescriprionActivity::class.java)
        intent.putExtra("product", item)
        startActivity(intent)
    }

    fun getProducts(context: Context){

        App.usersService.getProducts().enqueue(object : Callback<CatalogList>{
            override fun onFailure(call: Call<CatalogList>, t: Throwable) {
                Toast.makeText(this@Catalog, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("responceErr", "$t")

            }

            override fun onResponse(call: Call<CatalogList>, response: Response<CatalogList>) {
                response.body()?.let {
                    catalogRecView.layoutManager = LinearLayoutManager(context)
                    adapter = CatalogAdapter(it.products)
                    catalogRecView.adapter = adapter
                }
                Log.d("responce", "${response.body()}")

            }
        })
    }

//    fun getProducts():List<Product>{
//
//        var product: List<Product>
//
//        App.usersService.getProducts().enqueue(object : Callback<CatalogList>{
//            override fun onFailure(call: Call<CatalogList>, t: Throwable) {
//                Toast.makeText(this@Catalog, "${t.message}", Toast.LENGTH_SHORT).show()
//                Log.d("responceErr", "$t")
//
//            }
//
//            override fun onResponse(call: Call<CatalogList>, response: Response<CatalogList>) {
//                response.body()?.let { product = it.products }
//                Log.d("responce", "${response.body()}")
//            }
//        })
//        return product
//    }
}
