package com.roblesdotdev.doa.habits.presentation.detail

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime

data class DetailUIState(
    val id: String? = null,
    val habitName: String = "",
    val frequency: List<DayOfWeek> = emptyList(),
    val reminder: LocalTime = LocalTime.now(),
    val completedDates: List<LocalDate> = emptyList(),
    val startDate: ZonedDateTime = ZonedDateTime.now(),
    val isSaved: Boolean = false,
    val isLoading: Boolean = false,
)