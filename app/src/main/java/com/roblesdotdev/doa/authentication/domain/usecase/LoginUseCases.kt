package com.roblesdotdev.doa.authentication.domain.usecase

data class LoginUseCases(
    val loginWithCredentialsUseCase: LoginWithCredentialsUseCase,
    val validateEmailUseCase: ValidateEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
)