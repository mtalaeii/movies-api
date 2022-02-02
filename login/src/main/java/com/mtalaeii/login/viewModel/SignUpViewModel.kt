package com.mtalaeii.login.viewModel

import androidx.lifecycle.viewModelScope
import com.mtalaeii.core.BaseViewModel
import com.mtalaeii.core.request.ErrorType
import com.mtalaeii.core.request.RemoteErrorEmitter
import com.mtalaeii.login.model.Auth
import com.mtalaeii.login.model.SignUpResponse
import com.mtalaeii.login.request.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SignUpViewModel @Inject constructor(private var repo: Repository) : BaseViewModel(),
    RemoteErrorEmitter {
    var errorTypeCh = Channel<String>()
    var errorMsg = Channel<String>()
    val errorTypeFlow = errorTypeCh.receiveAsFlow()
    var errorMsgFlow = errorMsg.receiveAsFlow()
    val data = Channel<SignUpResponse>()
    var dataf = data.receiveAsFlow()
    fun signUp(field: Auth){
        repo.signUpNewUser(field).observeForever{
            if (it?.body() != null) {
                viewModelScope.launch {
                    data.send(it.body()!!)
                }
            }else{
                viewModelScope.launch {
                    errorMsg.send("Error on signUp check email!")
                }
            }
        }
    }
    fun starter() = repo.addEmitter(this)
    override fun onError(msg: String) {
        viewModelScope.launch {
            errorMsg.send(msg)
        }
    }

    override fun onError(errorType: ErrorType) {
        viewModelScope.launch {
            errorTypeCh.send(errorType.toString())
        }
    }
}