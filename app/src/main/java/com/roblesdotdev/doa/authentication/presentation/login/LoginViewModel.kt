package com.roblesdotdev.doa.authentication.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(LoginUIState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChange -> {
                uiState = uiState.copy(
                    email = event.email
                )
            }

            LoginEvent.Login -> {
                login()
            }
            is LoginEvent.PasswordChange -> {
                uiState = uiState.copy(
                    password = event.password
                )
            }

            LoginEvent.SignUp -> {
                uiState = uiState.copy(
                    signUp = true
                )
            }
        }
    }

    private fun login() {
        uiState = uiState.copy(isLoading = true)
    }
}