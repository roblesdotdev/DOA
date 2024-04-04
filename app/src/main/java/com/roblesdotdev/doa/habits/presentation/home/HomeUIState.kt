package com.roblesdotdev.doa.habits.presentation.home

import com.roblesdotdev.doa.habits.domain.model.Habit
import java.time.ZonedDateTime

data class HomeUIState(
    val habits: List<Habit> = emptyList(),
    val currentDate: ZonedDateTime = ZonedDateTime.now(),
    val selectedDate: ZonedDateTime = ZonedDateTime.now(),
)