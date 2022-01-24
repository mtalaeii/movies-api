package com.mtalaeii.login.di

import com.mtalaeii.login.request.Api
import com.mtalaeii.login.request.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @ViewModelScoped
    @Provides
    fun provideRepo(api: Api): Repository {
        return Repository(api)
    }

}