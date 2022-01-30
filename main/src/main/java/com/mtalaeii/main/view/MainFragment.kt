package com.mtalaeii.main.view

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.main.R
import com.mtalaeii.main.databinding.MainFragmentBinding
import com.mtalaeii.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding>() {


    override fun getLayoutRes(): Int {
       return R.layout.main_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.loginBtn.setOnClickListener {
            findNavController().navigate(Uri.parse("to://login"))
        }
        mBinding.searchBtn.setOnClickListener {
            findNavController().navigate(Uri.parse("to://search"))
        }
        super.onViewCreated(view, savedInstanceState)
    }

}