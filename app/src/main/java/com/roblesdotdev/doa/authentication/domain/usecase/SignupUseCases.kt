package com.roblesdotdev.doa.authentication.domain.usecase

data class SignupUseCases(
    val signUpWithCredentialsUseCase: SignupWithCredentialsUseCase,
    val validateEmailUseCase: ValidateEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
)