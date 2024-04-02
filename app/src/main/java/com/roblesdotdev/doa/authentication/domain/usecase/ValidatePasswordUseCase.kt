package com.roblesdotdev.doa.authentication.domain.usecase

class ValidatePasswordUseCase {
    operator fun invoke(password: String): PasswordResult {
        if (password.length < 8) {
            return PasswordResult.Invalid("Password must be at least 8 characters")
        }

        // MORE Validations

        return PasswordResult.Valid

    }
}

sealed class PasswordResult {
    data object Valid : PasswordResult()
    data class Invalid(val errorMessage: String) : PasswordResult()
}