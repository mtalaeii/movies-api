package com.mtalaeii.login.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.google.common.truth.Truth.assertThat
import com.mtalaeii.MainCoroutineRule
import com.mtalaeii.login.model.Auth
import com.mtalaeii.login.model.GetTokenResponse
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

class LoginViewModelTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    @Mock
    lateinit var repo:Repository
    lateinit var loginViewModel:LoginViewModel
    private val liveData = MutableLiveData<Response<GetTokenResponse>>()
    private val liveData2 = MutableLiveData<Response<SignUpResponse>>()
    companion object{
        val information = Auth("mahdi","12345","mahdi.talaee1379@gmail.com")
        val field = HashMap<String,String>()
        var responseField = GetTokenResponse("Bearer", accessToken = "122345")
        val infoField = SignUpResponse("mahdi","mahdi.talaee1379@gmail.com")
    }
    @Before
    fun setup(){
        field["grant_type"] = "password"
        field["username"] = "mahdi.talaee1379@gmail.com"
        field["password"] = "password"
        liveData.postValue(Response.success(responseField))
        liveData2.postValue(Response.success(infoField))
        loginViewModel = LoginViewModel(repo)
    }
    @Test
    fun `test signIn method`(){
        runBlockingTest {
            `when`(repo.getInfo("Bearer 122345")).thenReturn(liveData2)
            `when`(repo.signInUser(field)).thenReturn(liveData)
            loginViewModel.signIn(field)
            assertThat(loginViewModel.dataf.drop(0).first()).isEqualTo(infoField)
        }
    }
}