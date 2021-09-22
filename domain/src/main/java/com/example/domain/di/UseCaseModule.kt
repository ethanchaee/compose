package com.example.domain.di

import com.example.domain.usecase.activity.MainActivityUseCase
import com.example.domain.usecase.activity.MainActivityUseCaseImpl
import com.example.domain.usecase.splash.SplashUseCase
import com.example.domain.usecase.splash.SplashUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface UseCaseModule {
    @Binds
    fun bindMainActivityUseCase(useCase: MainActivityUseCaseImpl): MainActivityUseCase

    @Binds
    fun bindSplashUseCase(useCase: SplashUseCaseImpl): SplashUseCase
}
