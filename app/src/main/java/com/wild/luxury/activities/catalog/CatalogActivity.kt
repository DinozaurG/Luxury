package com.wild.luxury.activities.catalog

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.wild.luxury.network.CatalogList
import com.wild.luxury.network.Product
import com.wild.luxury.R
import com.wild.luxury.activities.ProductDescriprionActivity
import com.wild.luxury.App
import kotlinx.android.synthetic.main.activity_catalog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//import sun.jvm.hotspot.utilities.IntArray


class CatalogActivity : AppCompatActivity(),
    OnItemClickListener {

    private lateinit var toolbar : Toolbar
    private lateinit var adapter: CatalogAdapter
    lateinit var items: MutableList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Каталог"

        catalogRecView.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()
        getCatalogList()
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
                val userInput = query.toLowerCase()
                val newList: MutableList<Product> = ArrayList()
                if(items.isNotEmpty()) {
                    for (i in 0 until items.size) {
                        if (items[i].name.toLowerCase().contains(userInput)) {
                            newList.add(items[i])
                        }
                    }
                }
                adapter.updateList(newList)
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                val userInput = newText.toLowerCase()
                val newList: MutableList<Product> = ArrayList()
                if(items.isNotEmpty()) {
                    for (i in 0 until items.size) {
                        if (items[i].name.toLowerCase().contains(userInput)) {
                            newList.add(items[i])
                        }
                    }
                }
                adapter.updateList(newList)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onItemClicked(item: Product) {

        val roomType = intent.getIntExtra("roomType", -1)
        val intent = Intent(this, ProductDescriprionActivity::class.java)
        intent.putExtra("product", item)
        intent.putExtra("roomType", roomType)
        startActivity(intent)
    }

    private fun getCatalogList(){

        App.usersService.getProducts().enqueue(object : Callback<CatalogList> {
            override fun onFailure(call: Call<CatalogList>, t: Throwable) {
                Toast.makeText(this@CatalogActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("responceErr", "${t.message}")

            }

            override fun onResponse(call: Call<CatalogList>, response: Response<CatalogList>) {
                response.body()?.let {
                    items = it.products as MutableList<Product>
                    adapter = CatalogAdapter(
                        items,
                        this@CatalogActivity
                    )
                    catalogRecView.adapter = adapter

                }
                Log.d("responce", "${response.body()}")
            }
        })
    }
}
