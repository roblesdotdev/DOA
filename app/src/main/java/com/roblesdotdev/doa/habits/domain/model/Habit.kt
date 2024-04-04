package com.roblesdotdev.doa.habits.domain.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime

data class Habit(
    val id: String,
    val name: String,
    val frequency: List<DayOfWeek>,
    val completedDates: List<LocalDate>,
    val reminder: LocalTime,
    val startDate: ZonedDateTime,
)

val mockHabits = (1..15).map {
    Habit(
        id = "$it",
        name = "Habit $it",
        frequency = emptyList(),
        completedDates = emptyList(),
        reminder = LocalTime.MAX,
        startDate = ZonedDateTime.now()
    )
}