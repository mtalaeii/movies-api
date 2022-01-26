package com.mtalaeii.core.di

import com.mtalaeii.core.request.Api
import com.mtalaeii.core.request.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @ViewModelScoped
    @Provides
    fun provideRepo(api: Api): Repository {
        return Repository(api)
    }

}