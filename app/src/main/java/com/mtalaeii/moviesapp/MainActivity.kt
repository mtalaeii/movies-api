package com.mtalaeii.moviesapp

import com.mtalaeii.core.BaseActivity
import com.mtalaeii.moviesapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }
}