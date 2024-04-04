package com.roblesdotdev.doa.habits.di

import com.roblesdotdev.doa.habits.data.repository.HomeRepositoryImpl
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository
import com.roblesdotdev.doa.habits.domain.usecase.CompleteHabitUseCase
import com.roblesdotdev.doa.habits.domain.usecase.GetHabitsForDateUseCase
import com.roblesdotdev.doa.habits.domain.usecase.HomeUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun providesHomeUseCases(repository: HomeRepository): HomeUseCases {
        return HomeUseCases(
            completeHabitUseCase = CompleteHabitUseCase(repository),
            getHabitsForDateUseCase = GetHabitsForDateUseCase(repository)
        )
    }

    @Singleton
    @Provides
    fun providesHomeRepository(): HomeRepository {
        return HomeRepositoryImpl()
    }
}