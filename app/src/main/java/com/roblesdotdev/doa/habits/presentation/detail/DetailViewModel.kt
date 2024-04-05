package com.roblesdotdev.doa.habits.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.doa.habits.domain.model.Habit
import com.roblesdotdev.doa.habits.domain.usecase.DetailUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCases: DetailUseCases,
) : ViewModel() {
    var uiState by mutableStateOf(DetailUIState())
        private set

    init {
        val habitId = savedStateHandle.get<String?>("habitId")
        if (habitId != null) {
            viewModelScope.launch {
                val habit = useCases.getHabitByIdUseCase(habitId)
                uiState = uiState.copy(
                    habitName = habit.name,
                    startDate = habit.startDate,
                    frequency = habit.frequency,
                    reminder = habit.reminder,
                    completedDates = habit.completedDates,
                    id = habit.id
                )
            }
        }
    }

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.FrequencyChange -> {
                val frequency = if (uiState.frequency.contains(event.dayOfWeek)) {
                    uiState.frequency - event.dayOfWeek
                } else {
                    uiState.frequency + event.dayOfWeek
                }
                uiState = uiState.copy(
                    frequency = frequency
                )
            }
            DetailEvent.HabitSave -> {
                uiState = uiState.copy(
                    isLoading = true,
                )
                viewModelScope.launch {
                    val habit = Habit(
                        id = uiState.id ?: UUID.randomUUID().toString(),
                        name = uiState.habitName,
                        frequency = uiState.frequency,
                        completedDates = uiState.completedDates,
                        reminder = uiState.reminder,
                        startDate = uiState.startDate,
                    )
                    useCases.insertHabitUseCase(habit)
                }
                uiState = uiState.copy(
                    isSaved = true,
                    isLoading = false,
                )
            }
            is DetailEvent.NameChange -> {
                uiState = uiState.copy(
                    habitName = event.name
                )
            }
            is DetailEvent.ReminderChange -> {
                uiState = uiState.copy(
                    reminder = event.time
                )
            }
        }
    }
}