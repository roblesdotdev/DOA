package com.roblesdotdev.doa.habits.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(DetailUIState())
        private set


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
                    isSaved = true
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