package com.roblesdotdev.doa.authentication.domain.usecase

import com.roblesdotdev.doa.authentication.domain.repository.AuthenticationRepository

class LoginWithCredentialsUseCase(private val repository: AuthenticationRepository) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repository.login(email, password)
    }
}