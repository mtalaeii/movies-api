package com.mtalaeii.moviesapp.request

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class ApiModule {
    @Provides
    fun provideBaseUrl():String{
        return "https://moviesapi.ir/"
    }
    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL:String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
//    @Singleton
//    @Provides
//    fun provideApi(retrofit: Retrofit): Api {
//        return retrofit.create(Api::class.java)
//    }
}