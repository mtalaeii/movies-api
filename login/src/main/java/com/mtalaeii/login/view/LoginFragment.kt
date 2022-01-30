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
import com.mtalaeii.login.databinding.LoginFragmentBinding
import com.mtalaeii.login.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginFragmentBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name:EditText = mBinding.nameEdt
        val password:EditText = mBinding.passwordEdt
        val viewModel:LoginViewModel by viewModels()
        mBinding.btnLogin.setOnClickListener{
            when {
                name.text.isEmpty() -> name.error = "Required!"
                password.text.isEmpty()  -> password.error = "Required!"
                else -> {
                    viewModel.starter()
                    val map = HashMap<String,String>()
                    map["grant_type"] = "password"
                    map["username"] = name.text.toString()
                    map["password"] = password.text.toString()
                    viewModel.signIn(map)
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
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToInformationFragment(it))
            }}
            a.await()
            b.await()
            c.await()

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