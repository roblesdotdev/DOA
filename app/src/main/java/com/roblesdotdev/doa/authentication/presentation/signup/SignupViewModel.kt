package com.roblesdotdev.doa.authentication.presentation.signup

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.doa.authentication.domain.usecase.PasswordResult
import com.roblesdotdev.doa.authentication.domain.usecase.SignupUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCases: SignupUseCases
) : ViewModel() {
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
        if (!signupUseCases.validateEmailUseCase(uiState.email)) {
            uiState = uiState.copy(
                isLoading = false,
                emailError = "Invalid email"
            )
        }

        val passwordResult = signupUseCases.validatePasswordUseCase(uiState.password)
        if (passwordResult is PasswordResult.Invalid) {
            uiState = uiState.copy(
                isLoading = false,
                passwordError = passwordResult.errorMessage
            )
        }

        if (uiState.passwordError == null && uiState.emailError == null) {
            viewModelScope.launch {
                signupUseCases.signUpWithCredentialsUseCase(uiState.email, uiState.password).onSuccess {
                    uiState = uiState.copy(isLoading = false, isSignedIn = true)
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