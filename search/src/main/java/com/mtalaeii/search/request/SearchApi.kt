package com.mtalaeii.search.request

import com.mtalaeii.search.model.InfoResponse
import com.mtalaeii.search.model.InsertResponse
import com.mtalaeii.search.model.SearchResponse
import retrofit2.Response
import retrofit2.http.*

interface SearchApi {
    @GET("/api/v1/movies")
    suspend fun getByPage(
        @Query("page") page: Int
    ): Response<SearchResponse>
    @GET("api/v1/movies/{movie_id}")
    suspend fun getMovieInfo(@Path("movie_id") movie_id: Int): Response<InfoResponse>
    @Multipart
    @POST("/api/v1/movies/multi")
    suspend fun insertMovie(
        @PartMap map: HashMap<String, String>
    ): Response<InsertResponse>
}