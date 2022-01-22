package com.mtalaeii.login.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.login.R
import com.mtalaeii.login.databinding.LoginFragmentBinding
import com.mtalaeii.login.viewModel.LoginViewModel

class LoginFragment : BaseFragment<LoginFragmentBinding>() {


    override fun getLayoutRes(): Int {
        return R.layout.login_fragment
    }


}