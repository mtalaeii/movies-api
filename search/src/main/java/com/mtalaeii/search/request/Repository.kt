package com.mtalaeii.search.request

import com.mtalaeii.core.request.RemoteErrorEmitter
import com.mtalaeii.core.request.apiCall
import javax.inject.Inject

class Repository @Inject constructor(var searchApi: SearchApi){
    var emitter: RemoteErrorEmitter?=null
    fun getByPage(page:Int) = apiCall(emitter){
        searchApi.getByPage(page)
    }
    fun getMovieInfo(movie_id:Int) = apiCall(emitter){
        searchApi.getMovieInfo(movie_id)
    }
    fun getByName(name:String) = apiCall(emitter){
        searchApi.getByName(name = name)
    }
    fun addEmitter(emitter: RemoteErrorEmitter){
        this.emitter = emitter
    }
}