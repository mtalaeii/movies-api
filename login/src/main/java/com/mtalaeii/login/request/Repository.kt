package com.mtalaeii.login.request

import com.mtalaeii.core.RemoteErrorEmitter
import com.mtalaeii.core.apiCall
import com.mtalaeii.login.model.Auth


class Repository(var api:Api){
    var emitter: RemoteErrorEmitter?=null
    fun signUpNewUser(field:Auth) = apiCall(emitter){
        api.userSignUp("http://moviesapi.ir/api/v1/register",field)
    }
    fun signInUser(username:String,password:String) = apiCall(emitter){
        api.userLogin("http://moviesapi.ir/api/v1/register","password", username, password)
    }
    fun addEmitter(emitter: RemoteErrorEmitter){
        this.emitter = emitter
    }

}