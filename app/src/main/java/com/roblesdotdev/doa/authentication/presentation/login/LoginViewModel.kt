package com.roblesdotdev.doa.authentication.presentation.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.doa.authentication.domain.usecase.LoginUseCases
import com.roblesdotdev.doa.authentication.domain.usecase.PasswordResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases,
) :
    ViewModel() {
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
        uiState = uiState.copy(isLoading = true, emailError = null, passwordError = null)
        if (!loginUseCases.validateEmailUseCase(uiState.email)) {
            uiState = uiState.copy(
                isLoading = false,
                emailError = "Invalid email"
            )
        }

        val passwordResult = loginUseCases.validatePasswordUseCase(uiState.password)
        if (passwordResult is PasswordResult.Invalid) {
            uiState = uiState.copy(
                isLoading = false,
                passwordError = passwordResult.errorMessage
            )
        }
        if (uiState.passwordError == null && uiState.emailError == null) {
            viewModelScope.launch {
                loginUseCases.loginWithCredentialsUseCase(uiState.email, uiState.password).onSuccess {
                    uiState = uiState.copy(isLoading = false, isLoggedIn = true)
                    Log.d("AUTH", "LOGIN SUCCESS")
                }.onFailure {
                    val err = it.message
                    Log.e("AUTH", err.toString())
                    uiState = uiState.copy(isLoading = false)
                }
            }
        }
    }
}