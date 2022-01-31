package com.mtalaeii.search.di

import com.mtalaeii.search.request.Repository
import com.mtalaeii.search.request.SearchApi
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
    fun provideRepo(searchApi: SearchApi): Repository {
        return Repository(searchApi)
    }
}