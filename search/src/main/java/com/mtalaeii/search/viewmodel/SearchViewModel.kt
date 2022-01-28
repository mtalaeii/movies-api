package com.mtalaeii.search.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mtalaeii.core.BaseViewModel
import com.mtalaeii.core.request.Repository
import com.mtalaeii.search.request.MoviesDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(var repo:Repository):BaseViewModel() {
    val movies =
        Pager(config = PagingConfig(pageSize = 10, prefetchDistance = 2), pagingSourceFactory = {
            MoviesDataSource(repo)
        }).flow.cachedIn(viewModelScope)
}