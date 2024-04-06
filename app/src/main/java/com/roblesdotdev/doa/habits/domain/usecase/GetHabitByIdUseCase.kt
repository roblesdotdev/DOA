package com.roblesdotdev.doa.habits.domain.usecase

import com.roblesdotdev.doa.habits.domain.model.Habit
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetHabitByIdUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(habitId: String): Habit {
        return withContext(Dispatchers.IO) {
            repository.getHabitById(habitId)
        }
    }
}