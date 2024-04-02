package com.roblesdotdev.doa.authentication.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(SignupUIState())
        private set

    fun onEvent(event: SignupEvent) {
        when (event) {
            is SignupEvent.EmailChange -> {
                uiState = uiState.copy(email = event.email)
            }
            is SignupEvent.PasswordChange -> {
                uiState = uiState.copy(password = event.password)
            }
            SignupEvent.Signup -> {
                signup()
            }
        }
    }

    private fun signup() {
        uiState = uiState.copy(isLoading = true)
    }
}