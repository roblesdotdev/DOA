package com.roblesdotdev.doa.authentication.di

import com.roblesdotdev.doa.authentication.data.repository.AuthenticationRepositoryImpl
import com.roblesdotdev.doa.authentication.domain.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {

    @Provides
    @Singleton
    fun providesAuthenticationRepository(): AuthenticationRepository {
        return AuthenticationRepositoryImpl()
    }
}