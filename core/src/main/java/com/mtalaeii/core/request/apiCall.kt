package com.mtalaeii.core.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

fun <T> apiCall(emitter: RemoteErrorEmitter?, responseFunction:suspend () -> T) : LiveData<T?> {
    return liveData{
        val response = privateApiCall(emitter,responseFunction)
        emit(response)
    }
}

suspend fun <T> privateApiCall(emitter: RemoteErrorEmitter?, responseFunction: suspend () -> T): T? {
    try {
        return responseFunction()
    } catch (e: Exception) {
        withContext(Dispatchers.Main) {
            e.printStackTrace()
//            Log.e("apiCalls", "Call error: ${e.localizedMessage}", e.cause)
            when (e) {

                is HttpException -> {
                    val body = e.message
                    emitter?.onError("Error $body")
                }
                is TimeoutCancellationException -> {
                    emitter?.onError("Timeout! Please try again later")
                    emitter?.onError(ErrorType.TIMEOUT)
                }
                is IOException -> {
                    val body = e.message
                    emitter?.onError("Please check your connection! $body")
                    emitter?.onError(ErrorType.NETWORK)
                }
                else -> {
                    val body = e.message
                    emitter?.onError("Error $body")
                    emitter?.onError(ErrorType.UNKNOWN)
                }
            }
        }
        return null
    }
}
