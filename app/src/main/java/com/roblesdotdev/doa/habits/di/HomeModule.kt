package com.roblesdotdev.doa.habits.di

import android.content.Context
import androidx.room.Room
import com.roblesdotdev.doa.habits.data.local.HomeDao
import com.roblesdotdev.doa.habits.data.local.HomeDatabase
import com.roblesdotdev.doa.habits.data.local.typeconverter.HomeTypeConverter
import com.roblesdotdev.doa.habits.data.repository.HomeRepositoryImpl
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository
import com.roblesdotdev.doa.habits.domain.usecase.CompleteHabitUseCase
import com.roblesdotdev.doa.habits.domain.usecase.DetailUseCases
import com.roblesdotdev.doa.habits.domain.usecase.GetHabitByIdUseCase
import com.roblesdotdev.doa.habits.domain.usecase.GetHabitsForDateUseCase
import com.roblesdotdev.doa.habits.domain.usecase.HomeUseCases
import com.roblesdotdev.doa.habits.domain.usecase.InsertHabitUseCase
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun providesDetailUseCases(repository: HomeRepository): DetailUseCases {
        return DetailUseCases(
            insertHabitUseCase = InsertHabitUseCase(repository),
            getHabitByIdUseCase = GetHabitByIdUseCase(repository),
        )
    }

    @Singleton
    @Provides
    fun providesHabitDao(@ApplicationContext context: Context, moshi: Moshi): HomeDao {
        return Room.databaseBuilder(
            context,
            HomeDatabase::class.java,
            "habits_db"
        ).addTypeConverter(HomeTypeConverter(moshi)).build().dao
    }

    @Singleton
    @Provides
    fun providesHomeRepository(dao: HomeDao): HomeRepository {
        return HomeRepositoryImpl(dao)
    }

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}
