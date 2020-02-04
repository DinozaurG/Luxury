package com.wild.luxury.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wild.luxury.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val intent = Intent(this, ProductDescriprionActivity::class.java)

        startActivity(intent)
        finish()
    }
}