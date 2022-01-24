package com.mtalaeii.login.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mtalaeii.core.BaseViewModel
import com.mtalaeii.login.model.Auth
import com.mtalaeii.login.request.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(var repo:Repository) : BaseViewModel() {
    fun signUp(field:Auth){
        repo.signUpNewUser(field).observeForever{
            if (it != null) {
                Log.e("TAG", "signUp: ${it.body()}" )
            }
        }
    }
}