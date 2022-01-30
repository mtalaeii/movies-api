package com.mtalaeii.core.request

interface RemoteErrorEmitter {
    fun onError(msg:String)
    fun onError(errorType: ErrorType)
}

enum class ErrorType {
    NETWORK,//IO
    TIMEOUT,//Socket
    UNKNOWN ,//Anything else
}
