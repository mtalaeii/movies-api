package com.mtalaeii.login.viewModel

import androidx.lifecycle.viewModelScope
import com.mtalaeii.core.BaseViewModel
import com.mtalaeii.core.request.ErrorType
import com.mtalaeii.core.request.RemoteErrorEmitter
import com.mtalaeii.core.model.login.SignUpResponse
import com.mtalaeii.core.request.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(var repo: Repository): BaseViewModel(),
    RemoteErrorEmitter {
    var errorTypeCh = Channel<String>()
    var errorMsg = Channel<String>()
    val errorTypeFlow = errorTypeCh.receiveAsFlow()
    var errorMsgFlow = errorMsg.receiveAsFlow()
    val data = Channel<SignUpResponse>()
    var dataf = data.receiveAsFlow()
    fun signIn(map:HashMap<String,String>){
        repo.signInUser(map).observeForever {
            if (it?.body() != null) {
                repo.getInfo( "Bearer " + it.body()!!.accessToken.toString()).observeForever { it ->
                    if (it?.body() != null) {
                        viewModelScope.launch {
                            data.send(it.body()!!)
                        }
                    }else{
                        viewModelScope.launch {
                            errorMsg.send("Please check email and password")
                        }
                    }
                }

            }
            else{
                viewModelScope.launch {
                    errorMsg.send("Please check email and password")
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