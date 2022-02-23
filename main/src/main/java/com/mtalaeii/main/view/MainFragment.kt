package com.mtalaeii.main.view

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.mtalaeii.core.base.BaseFragment
import com.mtalaeii.main.R
import com.mtalaeii.main.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding>(MainFragmentBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        findNavController().navigate(Uri.parse("to://search"))
        super.onViewCreated(view, savedInstanceState)
    }

}