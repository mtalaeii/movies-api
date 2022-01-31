package com.mtalaeii.search.request

import androidx.paging.PagingSource
import com.mtalaeii.search.model.Data
import javax.inject.Inject

class MoviesDataSource @Inject constructor(var repo: Repository): PagingSource<Int, Data>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = repo.searchApi.getByPage(currentLoadingPageKey)
            val responseData = mutableListOf<Data>()
            val data = response.body()?.data ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}