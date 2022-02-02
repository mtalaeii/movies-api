package com.mtalaeii.login.view

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.login.R
import com.mtalaeii.login.databinding.SignUpFragmentBinding
import com.mtalaeii.login.model.Auth
import com.mtalaeii.login.viewModel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
@AndroidEntryPoint
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
                        viewModel.starter()
                        viewModel.signUp(Auth(name.text.toString(), password.text.toString(),email.text.toString()))

                }
            }
        }
        lifecycleScope.launchWhenStarted {
            val a = async { viewModel.errorMsgFlow.collect {
                Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
            }}
            val b = async { viewModel.errorTypeFlow.collect {
                Toast.makeText(requireContext(), "Type: $it", Toast.LENGTH_SHORT).show()
            }}
            val c = async { viewModel.dataf.collect {
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToInformationFragment(it))
            }}
            a.await()
            b.await()
            c.await()

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