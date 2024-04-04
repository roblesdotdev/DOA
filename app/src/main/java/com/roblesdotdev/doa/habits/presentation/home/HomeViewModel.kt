package com.roblesdotdev.doa.habits.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.doa.habits.domain.usecase.HomeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCases: HomeUseCases
) : ViewModel() {
    var uiState by mutableStateOf(HomeUIState())
        private set

    init {
        getHabits()
    }

    fun onEvent(event: HomeEvent) {
       when (event)  {
           is HomeEvent.ChangeDate -> {
               uiState = uiState.copy(
                   selectedDate = event.date
               )
               getHabits()
           }
           is HomeEvent.CompleteHabit -> {
               viewModelScope.launch {
                   homeUseCases.completeHabitUseCase(event.habit, uiState.selectedDate)
               }
           }
       }
    }

    private fun getHabits() {
        viewModelScope.launch {
            homeUseCases.getHabitsForDateUseCase(uiState.selectedDate).collectLatest { latestHabits ->
                uiState = uiState.copy(
                    habits = latestHabits
                )
            }
        }
    }
}