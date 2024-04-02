package com.roblesdotdev.doa.authentication.domain.usecase

import com.roblesdotdev.doa.authentication.domain.repository.AuthenticationRepository

class CheckSessionUseCase(private val repo: AuthenticationRepository) {
    operator fun invoke(): Boolean {
        return repo.hasSession()
    }
}