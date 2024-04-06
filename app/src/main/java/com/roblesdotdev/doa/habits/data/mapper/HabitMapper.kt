package com.roblesdotdev.doa.habits.data.mapper

import com.roblesdotdev.doa.habits.data.extension.toStartOfDateTimestamp
import com.roblesdotdev.doa.habits.data.extension.toTimeStamp
import com.roblesdotdev.doa.habits.data.extension.toZonedDateTime
import com.roblesdotdev.doa.habits.data.local.entity.HabitEntity
import com.roblesdotdev.doa.habits.domain.model.Habit
import java.time.DayOfWeek

fun HabitEntity.toDomain(): Habit {
    return Habit(
        id = this.id,
        name = this.name,
        frequency = this.frequency.map { DayOfWeek.of(it) },
        completedDates = this.completedDates.map { it.toZonedDateTime().toLocalDate() },
        reminder = this.reminder.toZonedDateTime().toLocalTime(),
        startDate = this.startDate.toZonedDateTime()
    )
}

fun Habit.toEntity(): HabitEntity {
    return HabitEntity(
        id = this.id,
        name = this.name,
        frequency = this.frequency.map { it.value },
        completedDates = this.completedDates.map { it.toZonedDateTime().toTimeStamp() },
        reminder = this.reminder.toZonedDateTime().toTimeStamp(),
        startDate = this.startDate.toStartOfDateTimestamp()
    )
}