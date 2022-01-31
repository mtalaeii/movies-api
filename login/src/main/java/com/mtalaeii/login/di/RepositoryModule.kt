package com.mtalaeii.login.di

import com.mtalaeii.login.request.LoginApi
import com.mtalaeii.login.request.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepo(loginApi: LoginApi): Repository {
        return Repository(loginApi)
    }
}