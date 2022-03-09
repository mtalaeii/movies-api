package com.mtalaeii.moviesapp.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtalaeii.core.base.BaseFragment
import com.mtalaeii.moviesapp.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        lifecycleScope.launchWhenCreated {
            delay(3000)
            findNavController().navigate(Uri.parse("to://search"))
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}