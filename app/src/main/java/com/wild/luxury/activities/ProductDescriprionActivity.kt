package com.wild.luxury.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wild.luxury.R
import kotlinx.android.synthetic.main.product_description.*


class ProductDescriprionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_description)




        val numProduct : TextView = findViewById(R.id.textNum)

        var numBuy = 0
        numProduct.text = numBuy.toString()
        addButton.setOnClickListener {
            numBuy++
            numProduct.text = numBuy.toString()
        }
        removeButton.setOnClickListener {
            if(numBuy!=0){
                numBuy--
                numProduct.text = numBuy.toString()
            }
        }

    }
}


