package com.mtalaeii.moviesapp.view

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.mtalaeii.core.base.BaseActivity
import com.mtalaeii.moviesapp.R
import com.mtalaeii.moviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
//        val inflater = navController.navInflater
//        val graph = inflater.inflate(R.navigation.main_nav)
//        navHostFragment.navController.graph = graph
        navController.apply {
            addOnDestinationChangedListener { _, _, _ ->
                if(this.currentDestination?.id == R.id.splashFragment)
                    binding.bottomNavigation.visibility = View.GONE
                else
                    binding.bottomNavigation.visibility = View.VISIBLE
                supportActionBar?.title = this.currentDestination?.label
            }
        }

    }
}