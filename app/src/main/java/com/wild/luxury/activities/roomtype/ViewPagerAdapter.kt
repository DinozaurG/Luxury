package com.wild.luxury.activities.roomtype

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TabFragment1()
            }
            1 -> TabFragment2()
            else -> {
                return TabFragment3()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Econom"
            1 -> "Standart"
            else -> {
                return "Luxury"
            }
        }
    }
}