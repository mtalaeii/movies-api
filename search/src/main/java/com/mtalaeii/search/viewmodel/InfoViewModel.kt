package com.mtalaeii.search.viewmodel
import androidx.lifecycle.viewModelScope
import com.mtalaeii.core.BaseViewModel
import com.mtalaeii.search.model.InfoResponse
import com.mtalaeii.core.request.ErrorType
import com.mtalaeii.core.request.RemoteErrorEmitter
import com.mtalaeii.search.request.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(var repo: Repository) : BaseViewModel(),RemoteErrorEmitter {
    var errorTypeCh = Channel<String>()
    var errorMsg = Channel<String>()
    val errorTypeFlow = errorTypeCh.receiveAsFlow()
    var errorMsgFlow = errorMsg.receiveAsFlow()
    private val infoData = Channel<InfoResponse>()
    var infoDataF = infoData.receiveAsFlow()
    fun getMovieInfo(movie_id:Int){
        repo.getMovieInfo(movie_id).observeForever {
            viewModelScope.launch {
                if(it?.body() != null)
                     infoData.send(it.body()!!)
                else{
                    viewModelScope.launch {
                        errorMsg.send("Cant get information!!")
                    }
                }

            }
        }
    }
    fun starter() {
        repo.addEmitter(this)
    }
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
