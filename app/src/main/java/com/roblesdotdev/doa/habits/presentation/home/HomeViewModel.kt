package com.roblesdotdev.doa.habits.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roblesdotdev.doa.habits.domain.model.mockHabits
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(HomeUIState())
        private set

    init {
        uiState = uiState.copy(
            habits = mockHabits
        )
    }

    fun onEvent(event: HomeEvent) {
       when (event)  {
           is HomeEvent.ChangeDate -> {
               uiState = uiState.copy(
                   selectedDate = event.date
               )
           }
           is HomeEvent.CompleteHabit -> {
           }
       }
    }
}