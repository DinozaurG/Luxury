package com.wild.luxury.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wild.luxury.activities.roomtype.RoomTypeActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, RoomTypeActivity::class.java)

        startActivity(intent)

        finish()
    }
}