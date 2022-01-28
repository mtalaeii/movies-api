package com.mtalaeii.core.request

import com.mtalaeii.core.model.Auth
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class Repository(var api: Api){
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
    fun getByPage(page:Int) = apiCall(emitter){
        api.getByPage(page)
    }
    fun addEmitter(emitter: RemoteErrorEmitter){
        this.emitter = emitter
    }

}