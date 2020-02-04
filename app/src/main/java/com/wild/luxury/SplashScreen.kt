package com.wild.luxury

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wild.luxury.activities.RoomTypeActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val intent = Intent(this, RoomTypeActivity::class.java)

        startActivity(intent)
        finish()
    }
}