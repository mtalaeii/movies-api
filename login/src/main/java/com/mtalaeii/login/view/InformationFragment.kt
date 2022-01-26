package com.mtalaeii.login.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.login.R
import com.mtalaeii.login.databinding.InformationFragmentBinding
import com.mtalaeii.login.viewModel.InformationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationFragment : BaseFragment<InformationFragmentBinding>() {
    private val args by navArgs<InformationFragmentArgs>()

    override fun getLayoutRes(): Int {
        return R.layout.information_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.data = args.data

        super.onViewCreated(view, savedInstanceState)
    }

}
