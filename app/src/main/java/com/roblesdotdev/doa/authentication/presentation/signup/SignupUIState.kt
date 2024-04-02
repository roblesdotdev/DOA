package com.roblesdotdev.doa.authentication.presentation.signup

data class SignupUIState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
)