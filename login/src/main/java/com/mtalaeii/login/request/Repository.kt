package com.mtalaeii.login.request

import com.mtalaeii.login.model.Auth
import com.mtalaeii.core.request.RemoteErrorEmitter
import com.mtalaeii.core.request.apiCall
import javax.inject.Inject

class Repository @Inject constructor(var api:LoginApi) {
    var emitter: RemoteErrorEmitter?=null
    fun signUpNewUser(field: Auth) = apiCall(emitter){
        api.userSignUp(field)
    }
    fun signInUser(map:HashMap<String,String>) = apiCall(emitter){
        api.userLogin(map)
    }
    fun getInfo(auth:String) = apiCall(emitter){
        api.getUserInfo(auth)
    }
    fun addEmitter(emitter: RemoteErrorEmitter){
        this.emitter = emitter
    }
}