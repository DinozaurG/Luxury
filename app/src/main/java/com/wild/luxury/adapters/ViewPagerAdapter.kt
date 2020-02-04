package com.wild.luxury.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wild.luxury.fragments.TabFragment1
import com.wild.luxury.fragments.TabFragment2
import com.wild.luxury.fragments.TabFragment3

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
            0 -> "Modest"
            1 -> "Moderate"
            else -> {
                return "Luxury"
            }
        }
    }
}