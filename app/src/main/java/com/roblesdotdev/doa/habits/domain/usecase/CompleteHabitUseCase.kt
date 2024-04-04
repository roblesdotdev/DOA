package com.roblesdotdev.doa.habits.domain.usecase

import com.roblesdotdev.doa.habits.domain.model.Habit
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository
import java.time.ZonedDateTime

class CompleteHabitUseCase(
    private val repo: HomeRepository
) {

    suspend operator fun invoke(habit: Habit, date: ZonedDateTime) {
        val newHabit = if (habit.completedDates.contains(date.toLocalDate())) {
            habit.copy(
                completedDates = habit.completedDates - date.toLocalDate()
            )
        } else {
            habit.copy(
                completedDates = habit.completedDates + date.toLocalDate()
            )
        }
        repo.insertHabit(newHabit.copy(name = "Edited habit"))
    }
}