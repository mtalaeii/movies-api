package com.mtalaeii.login.view

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.login.R
import com.mtalaeii.login.databinding.SignUpFragmentBinding
import com.mtalaeii.login.model.Auth
import com.mtalaeii.login.viewModel.SignUpViewModel

class SignUpFragment : BaseFragment<SignUpFragmentBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name: EditText = mBinding.nameEdt
        val password: EditText = mBinding.passwordEdt
        val email: EditText = mBinding.emailEdt
        val viewModel:SignUpViewModel by viewModels()
        mBinding.btnSignup.setOnClickListener{
            when {
                name.text.isEmpty() -> name.error = "Required!"
                password.text.isEmpty()  -> password.error = "Required!"
                email.text.isEmpty()->email.error = "Required!"
                else -> {
                    viewModel.signUp(Auth(name.text.toString(), password.text.toString(),email.text.toString()))
                }
            }
        }
        mBinding.txtLoginInstead.setOnClickListener{
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
        }
        super.onViewCreated(view, savedInstanceState)
    }
    override fun getLayoutRes(): Int {
        return R.layout.sign_up_fragment
    }

}