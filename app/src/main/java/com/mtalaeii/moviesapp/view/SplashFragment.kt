package com.mtalaeii.moviesapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.moviesapp.R
import com.mtalaeii.moviesapp.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launchWhenCreated {
            delay(3000)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainPageNav())
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun getLayoutRes(): Int {
        return R.layout.fragment_splash
    }

}