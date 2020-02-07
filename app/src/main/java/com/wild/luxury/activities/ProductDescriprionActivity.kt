package com.wild.luxury.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.wild.luxury.BuyProduct
import com.wild.luxury.Product
import com.wild.luxury.R
import com.wild.luxury.network.App
import kotlinx.android.synthetic.main.product_description.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductDescriprionActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_description)

        val product = intent.getSerializableExtra("product") as Product

        Picasso.get().load("https://imageog.flaticon.com/icons/png/512/89/89981.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF").into(imageView)

        productName.text = product.name
        textDescription.text = product.description
        buyProduct.text = "Купить : ${product.price}"

        buyProduct.setOnClickListener {
                val intent = Intent(this, MainRoomActivity::class.java)
                val productBuy = BuyProduct(1,product.id,1)
                postProduct(productBuy)
                //intent.putExtra("product",product)
                startActivity(intent)
                finish()
        }

    }


    private fun postProduct(productBuy:BuyProduct){

        App.usersService.postProduct(productBuy).enqueue(object : Callback<Product> {
            override fun onFailure(call: Call<Product>, t: Throwable) {
                Toast.makeText(this@ProductDescriprionActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("responceError", "${t.message}")

            }

            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                Toast.makeText(this@ProductDescriprionActivity, "Successful", Toast.LENGTH_SHORT).show()
                response.body()
                Log.d("Suc","Successful!")
            }
        })
    }
}


