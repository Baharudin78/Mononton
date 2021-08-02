package com.baharudin.mononton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapterPager = VIewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager.adapter = adapterPager
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#FF0026"))

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Film"
                }
                1 -> {
                    tab.text = "Search"
                }
            }
        }.attach()
    }
}