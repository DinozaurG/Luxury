package com.wild.luxury.activities

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.Product
import com.wild.luxury.R
import com.wild.luxury.adapters.CatalogAdapter
import com.wild.luxury.adapters.OnItemClickListener
import com.wild.luxury.network.App
import kotlinx.android.synthetic.main.activity_catalog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//import sun.jvm.hotspot.utilities.IntArray


class Catalog : AppCompatActivity(),
    OnItemClickListener {

    val items: ArrayList<Product> = ArrayList()
    private lateinit var toolbar : Toolbar
    private lateinit var adapter: CatalogAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

            for (i in 1..10) {
            items.add(Product("Table $i", 500 * i,3,"ASD", "h"))
        }

        //val items = getProducts()

        val itemsList = findViewById<RecyclerView>(R.id.catalogRecView)
        itemsList.layoutManager = LinearLayoutManager(this)
        adapter = CatalogAdapter(items, this)
        itemsList.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.catalog_menu, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView? = searchItem?.actionView as SearchView

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView?.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@Catalog,"Submitted",Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(this@Catalog,"Changed",Toast.LENGTH_LONG).show()
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
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

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                response.body()?.let { product = it }
            }
        })
        return product
    }
}
