package com.mtalaeii.search.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.search.R
import com.mtalaeii.search.databinding.InfoFragmentBinding
import com.mtalaeii.search.viewmodel.InfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class InfoFragment : BaseFragment<InfoFragmentBinding>() {
    val viewModel:InfoViewModel by viewModels()
    val args by navArgs<InfoFragmentArgs>()
    override fun getLayoutRes(): Int {
        return R.layout.info_fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.starter()
        viewModel.getMovieInfo(args.data.id)
        mBinding.viewModel = viewModel
        lifecycleScope.launchWhenStarted {
            val a = async { viewModel.errorMsgFlow.collect {
                Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
            }}
            val b = async { viewModel.errorTypeFlow.collect {
                Toast.makeText(requireContext(), "Type: $it", Toast.LENGTH_SHORT).show()
            }}
            val c = async { viewModel.infoDataF.collect {
                Glide.with(requireContext()).load(it.poster).into(mBinding.imgPoster)
                mBinding.data = it
            }}
            a.await()
            b.await()
            c.await()

        }
        super.onViewCreated(view, savedInstanceState)
    }

}