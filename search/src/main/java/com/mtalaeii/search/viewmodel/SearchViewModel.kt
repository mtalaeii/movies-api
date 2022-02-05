package com.mtalaeii.search.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mtalaeii.core.BaseViewModel
import com.mtalaeii.search.model.Data
import com.mtalaeii.core.request.ErrorType
import com.mtalaeii.core.request.RemoteErrorEmitter
import com.mtalaeii.search.adapter.MoviesAdapter
import com.mtalaeii.search.adapter.OnItemClick
import com.mtalaeii.search.request.MoviesDataSource
import com.mtalaeii.search.request.Repository
import com.mtalaeii.search.request.SearchDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(var repo: Repository, var adapter: MoviesAdapter): BaseViewModel(),
    RemoteErrorEmitter,OnItemClick {
    var errorTypeCh = Channel<String>()
    var errorMsg = Channel<String>()
    val errorTypeFlow = errorTypeCh.receiveAsFlow()
    var errorMsgFlow = errorMsg.receiveAsFlow()
    private val info = Channel<Data>()
    var infoFlow = info.receiveAsFlow()
    val movies =
        Pager(config = PagingConfig(pageSize = 10, prefetchDistance = 2), pagingSourceFactory = {
            MoviesDataSource(repo)
        }).flow.cachedIn(viewModelScope)
    fun getByName(name:String): Flow<PagingData<Data>> {
        return Pager(config = PagingConfig(pageSize = 10, prefetchDistance = 2), pagingSourceFactory = {
            SearchDataSource(repo,name)
        }).flow.cachedIn(viewModelScope)
    }
    fun starter() {
        repo.addEmitter(this)
        adapter.setUpListener(this)
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

    override fun onClick(data: Data) {
        viewModelScope.launch {
            info.send(data)
        }
    }
}