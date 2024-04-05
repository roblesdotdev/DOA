package com.roblesdotdev.doa.habits.domain.usecase

import com.roblesdotdev.doa.habits.domain.model.Habit
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository

class GetHabitByIdUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(habitId: String): Habit {
       return repository.getHabitById(habitId)
    }
}