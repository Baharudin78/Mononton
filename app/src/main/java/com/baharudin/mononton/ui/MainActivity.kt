package com.baharudin.mononton.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.baharudin.mononton.R
import com.baharudin.mononton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigation = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navigation.navController

        binding.apply {
            bottomNavigationView.setupWithNavController(navController)
            navigation.findNavController().addOnDestinationChangedListener{_, destination, _ ->
                when(destination.id) {
                    R.id.homeFragment2, R.id.searchFragment2, R.id.bookmarkFragment ->
                        bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
        }


    }
}