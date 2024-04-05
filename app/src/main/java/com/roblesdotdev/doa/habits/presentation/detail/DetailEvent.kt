package com.roblesdotdev.doa.habits.presentation.detail

import java.time.DayOfWeek
import java.time.LocalTime

sealed interface DetailEvent {
    data class ReminderChange(val time: LocalTime) : DetailEvent
    data class FrequencyChange(val dayOfWeek: DayOfWeek) : DetailEvent
    data class NameChange(val name: String) : DetailEvent
    data object HabitSave : DetailEvent
}