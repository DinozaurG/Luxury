package com.wild.luxury.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wild.luxury.Product
import com.wild.luxury.R
import kotlinx.android.synthetic.main.product_description.*


class ProductDescriprionActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_description)

        val numProduct : TextView = findViewById(R.id.textNum)

        var product = intent.getSerializableExtra("product") as Product

        productName.text = product.name
        textDescription.text = product.description


        var numBuy = 0
        numProduct.text = numBuy.toString()
        addButton.setOnClickListener {
            numBuy++
            buyProduct.text = "Купить: ${numBuy * product.price}"
            numProduct.text = numBuy.toString()
        }
        removeButton.setOnClickListener {
            if(numBuy!=0){
                numBuy--
                buyProduct.text = "Купить: ${numBuy * product.price}"
                numProduct.text = numBuy.toString()
            }
        }

        buyProduct.setOnClickListener {
            if(numBuy!=0){
                val intent = Intent(this, MainRoomActivity::class.java)
                product.count = numBuy
                intent.putExtra("product",product)
                startActivity(intent)
                finish()
            }
        }
    }
}


