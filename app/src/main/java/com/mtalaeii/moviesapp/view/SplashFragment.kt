package com.mtalaeii.moviesapp.view

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.moviesapp.R
import com.mtalaeii.moviesapp.databinding.FragmentSplashBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import android.os.Looper
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mtalaeii.moviesapp.viewmodel.SplashViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel : SplashViewModel by viewModels()
        lifecycleScope.launchWhenCreated {
            delay(3000)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginNav())
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun getLayoutRes(): Int {
        return R.layout.fragment_splash
    }

}