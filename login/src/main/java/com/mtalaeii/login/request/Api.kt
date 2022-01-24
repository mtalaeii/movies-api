package com.mtalaeii.login.request

import com.mtalaeii.login.model.Auth
import retrofit2.Response
import retrofit2.http.*


interface Api {
    @FormUrlEncoded
    @POST
    suspend fun userLogin(
        @Url url:String,
        @Field("grant_type") grant_type:String = "password",
        @Field("username") username:String,
        @Field("password") password:String
    )
    @POST
    suspend fun userSignUp(
        @Url url:String,
        @Body field:Auth
    ):Response<String>


}