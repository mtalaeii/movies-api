package com.mtalaeii.login.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.mtalaeii.core.base.BaseFragment
import com.mtalaeii.login.databinding.InformationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InformationFragment : BaseFragment<InformationFragmentBinding>(InformationFragmentBinding::inflate) {
    private val args by navArgs<InformationFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.data = args.data

        super.onViewCreated(view, savedInstanceState)
    }

}
