package com.mtalaeii.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.findNavController

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: DB
    @LayoutRes
    abstract fun getLayoutRes(): Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())

    }

}