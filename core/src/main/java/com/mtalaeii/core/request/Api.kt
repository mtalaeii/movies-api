package com.mtalaeii.core.request

import com.mtalaeii.core.model.Auth
import com.mtalaeii.core.model.GetTokenResponse
import com.mtalaeii.core.model.SignUpResponse
import retrofit2.Response
import retrofit2.http.*
interface Api {
    @FormUrlEncoded
    @POST("/oauth/token")
    suspend fun userLogin(
        @FieldMap map:HashMap<String,String>
    ):Response<GetTokenResponse>

    @Headers("Content-Type: application/json; charset=utf-8", "Accept:application/json")
    @POST("/api/v1/register")
    suspend fun userSignUp(
        @Body field: Auth
    ):Response<SignUpResponse>
    @GET("/api/user")
    suspend fun getUserInfo(
        @Header("Authorization") auth:String,
        @Header("Accept") accept:String = "application/json"
    ):Response<SignUpResponse>
//    @GET("/api/v1/movies")
//    suspend fun getByPage(
//        @Query("page") page: Int
//    ):Response<SearchResponse>

}