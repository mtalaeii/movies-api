package com.mtalaeii.login.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.google.common.truth.Truth.assertThat
import com.mtalaeii.MainCoroutineRule
import com.mtalaeii.login.model.Auth
import com.mtalaeii.login.model.SignUpResponse
import com.mtalaeii.login.request.Repository
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
class SignUpViewModelTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    @Mock
    lateinit var repo:Repository
    lateinit var signUpViewModel:SignUpViewModel
    private val liveData = MutableLiveData<Response<SignUpResponse>>()
    companion object{
        val field = Auth("mahdi","12345","mahdi.talaee1379@gmail.com")
        var responseField = SignUpResponse("mahdi","mahdi.talaee1379@gmail.com")
    }
    @Before
    fun setup(){
        liveData.postValue(Response.success(responseField))
        signUpViewModel = SignUpViewModel(repo)
    }

    @Test
    fun `test signup method`(){
        runBlockingTest {
            `when`(repo.signUpNewUser(field)).thenReturn(liveData)
            signUpViewModel.signUp(field)
            assertThat(signUpViewModel.dataf.drop(0).first()).isEqualTo(responseField)
        }
    }
}