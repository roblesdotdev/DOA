package com.roblesdotdev.doa.habits.data.repository

import com.roblesdotdev.doa.habits.domain.model.Habit
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime

class HomeRepositoryImpl: HomeRepository {
    private val mockHabits = (1..10).map {
        val dates = mutableListOf<LocalDate>()
        if (it % 2 == 0) {
            dates.add(LocalDate.now())
        }
        Habit(
            id = "$it",
            name = "Habit $it",
            frequency = emptyList(),
            completedDates = dates,
            reminder = LocalTime.now(),
            startDate = ZonedDateTime.now()
        )
    }.toMutableList()

    override fun getAllHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>> {
        return flowOf(mockHabits)
    }

    override suspend fun insertHabit(habit: Habit) {
        val idx = mockHabits.indexOfFirst { it.id == habit.id }
        mockHabits.removeAt(idx)
        mockHabits.add(idx, habit)
    }
}