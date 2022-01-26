package com.mtalaeii.core.request
import com.mtalaeii.core.model.Auth
import com.mtalaeii.core.model.SignUpResponse
import retrofit2.Response
import retrofit2.http.*


interface Api {
    @FormUrlEncoded
    @POST("/oauth/token")
    suspend fun userLogin(
        @Field("grant_type") grant_type:String = "password",
        @Field("username") username:String,
        @Field("password") password:String
    )
    @Headers("Content-Type: application/json; charset=utf-8", "Accept:application/json")
    @POST("/api/v1/register")
    suspend fun userSignUp(
        @Body field:Auth
    ):Response<SignUpResponse>


}