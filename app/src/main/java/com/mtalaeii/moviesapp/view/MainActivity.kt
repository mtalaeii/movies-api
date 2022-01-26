package com.mtalaeii.moviesapp.view

import com.mtalaeii.core.BaseActivity
import com.mtalaeii.moviesapp.R
import com.mtalaeii.moviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_main

    }
}