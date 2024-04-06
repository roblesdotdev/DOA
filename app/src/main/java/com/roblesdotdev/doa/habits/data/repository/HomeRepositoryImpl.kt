package com.roblesdotdev.doa.habits.data.repository

import com.roblesdotdev.doa.habits.data.extension.toStartOfDateTimestamp
import com.roblesdotdev.doa.habits.data.local.HomeDao
import com.roblesdotdev.doa.habits.data.local.entity.HabitEntity
import com.roblesdotdev.doa.habits.data.mapper.toDomain
import com.roblesdotdev.doa.habits.data.mapper.toEntity
import com.roblesdotdev.doa.habits.domain.model.Habit
import com.roblesdotdev.doa.habits.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.ZonedDateTime

class HomeRepositoryImpl(
    private val dao: HomeDao
) : HomeRepository {
    override fun getAllHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>> {
        return dao.getAllHabitsForSelectedDate(date.toStartOfDateTimestamp())
            .map { it.map(HabitEntity::toDomain) }
    }

    override suspend fun insertHabit(habit: Habit) {
        dao.insertHabit(habit.toEntity())
    }

    override suspend fun getHabitById(id: String): Habit {
        return dao.getHabitById(id).toDomain()
    }
}