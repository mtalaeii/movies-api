package com.mtalaeii.search.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.google.common.truth.Truth.assertThat
import com.mtalaeii.MainCoroutineRule
import com.mtalaeii.search.model.Data
import com.mtalaeii.search.model.InfoResponse
import com.mtalaeii.search.model.SearchResponse
import com.mtalaeii.search.request.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
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
class InfoViewModelTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    @Mock
    lateinit var repo: Repository
    private lateinit var infoViewModel:InfoViewModel
    private val liveData = MutableLiveData<Response<InfoResponse>>()
    companion object{
        val response = InfoResponse(
            1234,
            "",
            "",
            2010,
            "1.0",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            123,
            5.5,
            "",
            "",
            "",
            listOf(),
            listOf()
        )
    }
    @Before
    fun setup(){
        infoViewModel = InfoViewModel(repo)
        liveData.postValue(Response.success(response))
    }

    @Test
    fun `on movie id correct`(){
        runBlockingTest {
            `when`(repo.getMovieInfo(1234)).thenReturn(liveData)
            infoViewModel.getMovieInfo(1234)
            assertThat(infoViewModel.infoDataF.drop(0).first()).isEqualTo(response)
        }
    }
}