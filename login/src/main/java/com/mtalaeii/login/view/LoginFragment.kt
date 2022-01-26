package com.mtalaeii.login.view

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.login.R
import com.mtalaeii.login.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginFragmentBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name:EditText = mBinding.nameEdt
        val password:EditText = mBinding.passwordEdt
        mBinding.btnLogin.setOnClickListener{
            when {
                name.text.isEmpty() -> name.error = "Required!"
                password.text.isEmpty()  -> password.error = "Required!"
                else -> Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
            }
        }
        mBinding.txtDontHave.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }


        super.onViewCreated(view, savedInstanceState)
    }
    override fun getLayoutRes(): Int {
        return R.layout.login_fragment
    }


}