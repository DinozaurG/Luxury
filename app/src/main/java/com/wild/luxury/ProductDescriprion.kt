package com.wild.luxury

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.product_description.*
import kotlin.text.toInt as toInt1

@SuppressLint("Registered")
class ProductDescriprion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_description)




        var numProduct : TextView = findViewById(R.id.textNum)



        addButton.setOnClickListener {
        }
    }
}


