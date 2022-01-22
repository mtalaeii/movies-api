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
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import kotlin.concurrent.thread


class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val thread = Thread(Runnable {
            kotlin.run {
                Thread.sleep(3000)
                findNavController().navigate(Uri.parse("to//login"))
            }

        })
        thread.start()
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun getLayoutRes(): Int {
        return R.layout.fragment_splash
    }
}