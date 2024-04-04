package com.roblesdotdev.doa.habits.presentation.home

import com.roblesdotdev.doa.habits.domain.model.Habit
import java.time.ZonedDateTime

sealed interface HomeEvent {
    data class ChangeDate(val date: ZonedDateTime) : HomeEvent
    data class CompleteHabit(val habit: Habit) : HomeEvent
}