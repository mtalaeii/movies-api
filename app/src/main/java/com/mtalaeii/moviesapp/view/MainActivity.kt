package com.mtalaeii.moviesapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.mtalaeii.core.BaseActivity
import com.mtalaeii.moviesapp.R
import com.mtalaeii.moviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_main

    }

    override fun onCreate(savedInstanceState: Bundle?) {
// setting title according to fragment
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(getNavHostLayout()) as NavHostFragment
//        val navController = navHostFragment.navController
//        navController.addOnDestinationChangedListener {
//                controller, destination, arguments ->
//            supportActionBar?.title = navController.currentDestination?.label
//        }
        super.onCreate(savedInstanceState)
    }
    private fun getNavHostLayout():Int{
        return R.id.nav_host_fragment
    }
}