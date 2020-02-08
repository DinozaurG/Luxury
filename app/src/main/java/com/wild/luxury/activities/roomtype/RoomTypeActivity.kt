package com.wild.luxury.activities.roomtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wild.luxury.R
import kotlinx.android.synthetic.main.activity_room_type.*

class RoomTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_type)

        val viewPagerAdapter =
            ViewPagerAdapter(
                supportFragmentManager
            )
        viewPager.adapter = viewPagerAdapter

        viewPager.currentItem = 1
        viewPager.setPadding(64, 0, 64, 0)
        viewPager.clipToPadding = false
        viewPager.pageMargin = 8

        tab_layout.setupWithViewPager(viewPager)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}
