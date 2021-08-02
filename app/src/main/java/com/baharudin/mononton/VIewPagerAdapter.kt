package com.baharudin.mononton

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.baharudin.mononton.ui.fragment.HomeFragment
import com.baharudin.mononton.ui.fragment.SearchFragment

class VIewPagerAdapter(fragmentManager : FragmentManager, lifeCycle : Lifecycle) : FragmentStateAdapter(fragmentManager, lifeCycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0-> {
                HomeFragment()
             }
            1 -> {
                SearchFragment()
             }
            else -> {
                Fragment()
            }
        }
    }
}