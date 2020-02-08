package com.wild.luxury.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.wild.luxury.network.BuyProduct
import com.wild.luxury.network.Product
import com.wild.luxury.R
import com.wild.luxury.activities.room.MainRoomActivity
import com.wild.luxury.App
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

        Picasso.get()
            .load(product.photoUrl)
            .placeholder(R.drawable.loading_img)
            .error(R.drawable.ic_broken_image)
            .into(imageView)

        productName.text = product.name
        product_category.text = product.category
        product_price.text = "${product.price} $"
        textDescription.text = product.description
        buyButton.text = "Buy"

        val buttonClick = AlphaAnimation(1f, 0.2f)
        
        buyButton.setOnClickListener {

            it.startAnimation(buttonClick)

            val roomType = intent.getIntExtra("roomType", -1)
            postProduct(BuyProduct(1, product.id, roomType))

            val intent = Intent(this, MainRoomActivity::class.java)
            intent.putExtra("roomType", roomType)
            startActivity(intent)
            finish()
        }

    }


    private fun postProduct(productBuy: BuyProduct) {

        App.usersService.postProduct(productBuy).enqueue(object : Callback<Product> {
            override fun onFailure(call: Call<Product>, t: Throwable) {
                Toast.makeText(this@ProductDescriprionActivity, "${t.message}", Toast.LENGTH_SHORT)
                    .show()
                Log.d("responceError", "${t.message}")

            }

            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                response.body()
                Log.d("Suc", "Successful!")
            }
        })
    }
}


