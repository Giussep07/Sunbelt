package com.giussepr.sunbelt.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.giussepr.sunbelt.R
import com.giussepr.sunbelt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.splashFragment,
                R.id.homeFragment
            )
        )

        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfig)

        navControllerDestinationChangedListener()
    }

    private fun navControllerDestinationChangedListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    hideToolbar()
                }
                else -> {
                    showToolbar()
                }
            }
        }
    }

    private fun hideToolbar() {
        binding.toolbar.isVisible = false
    }

    private fun showToolbar() {
        binding.toolbar.isVisible = true
    }
}