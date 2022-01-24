package com.mtalaeii.moviesapp.view

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.mtalaeii.core.BaseActivity
import com.mtalaeii.moviesapp.R
import com.mtalaeii.moviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
    }
    override fun getLayoutRes(): Int {
        return R.layout.activity_main

    }
}