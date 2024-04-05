package com.roblesdotdev.doa.habits.domain.usecase

import com.roblesdotdev.doa.habits.domain.model.Habit
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository

class InsertHabitUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(habit: Habit) {
        repository.insertHabit(habit)
    }
}