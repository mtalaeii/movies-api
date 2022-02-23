package com.mtalaeii.search.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.google.common.truth.Truth.assertThat
import com.mtalaeii.MainCoroutineRule
import com.mtalaeii.search.adapter.MoviesAdapter
import com.mtalaeii.search.model.Data
import com.mtalaeii.search.model.SearchResponse
import com.mtalaeii.search.request.Repository
import com.mtalaeii.search.request.SearchDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class SearchViewModelTest{
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//    @get:Rule
//    var mainCoroutineRule = MainCoroutineRule()
//    @Mock
//    lateinit var repo: Repository
//    @Mock
//    lateinit var adapter:MoviesAdapter
//    private lateinit var searchViewModel: SearchViewModel
//    private var liveData = MutableLiveData<Response<SearchResponse>>()
//    lateinit var searchDataSource:SearchDataSource
//    companion object{
//        val response = SearchResponse(listOf(),com.mtalaeii.search.model.Metadata(0,1,1,1))
//    }
//    @Before
//    fun setup(){
//        liveData.postValue(Response.success(response))
//        searchViewModel = SearchViewModel(repo,adapter)
//    }
//    @Test
//    fun `test search fun with correct fields`(){
//        runBlockingTest {
//            val response2 = PagingSource.LoadResult.Page(
//                data = listOf<Data>(),
//                prevKey = 0,
//                nextKey = 2
//            )
//            `when`(repo.getByName(name = "The Dark")).thenReturn(liveData)
//            searchViewModel.getByName("The Dark")
//            searchDataSource = SearchDataSource(repo,"The Dark")
//            assertThat(searchDataSource.load(
//                PagingSource.LoadParams.Prepend(
//                    key = 1,
//                    loadSize = 1,
//                    placeholdersEnabled = false
//                )
//            )).isEqualTo(response2)
//
//        }
//    }

}