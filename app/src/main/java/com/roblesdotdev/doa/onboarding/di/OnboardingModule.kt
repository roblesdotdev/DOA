package com.roblesdotdev.doa.onboarding.di

import android.content.Context
import android.content.SharedPreferences
import com.roblesdotdev.doa.onboarding.data.repository.OnboardingRepositoryImpl
import com.roblesdotdev.doa.onboarding.domain.repository.OnboardingRepository
import com.roblesdotdev.doa.onboarding.domain.usecase.CompleteOnboardingUseCase
import com.roblesdotdev.doa.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object OnboardingModule {
    @Provides
    @Singleton
    fun providesSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("doa_app", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesOnboardingRepository(sharedPreferences: SharedPreferences): OnboardingRepository {
        return OnboardingRepositoryImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun providesHasSeenOnboardingUseCase(repository: OnboardingRepository): HasSeenOnboardingUseCase {
        return HasSeenOnboardingUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesCompleteOnboardingUseCase(repository: OnboardingRepository): CompleteOnboardingUseCase {
        return CompleteOnboardingUseCase(repository)
    }
}