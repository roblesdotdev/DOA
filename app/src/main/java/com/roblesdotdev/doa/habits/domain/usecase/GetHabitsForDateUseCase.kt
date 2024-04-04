package com.roblesdotdev.doa.habits.domain.usecase

import com.roblesdotdev.doa.habits.domain.model.Habit
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime

class GetHabitsForDateUseCase(
    private val repo: HomeRepository
) {
    operator fun invoke(date: ZonedDateTime) : Flow<List<Habit>> {
        return repo.getAllHabitsForSelectedDate(date)
    }
}