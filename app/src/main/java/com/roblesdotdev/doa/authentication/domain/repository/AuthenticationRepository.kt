package com.roblesdotdev.doa.authentication.domain.repository

interface AuthenticationRepository {
    suspend fun login(email: String, password: String) : Result<Unit>
    suspend fun signup(email: String, password: String) : Result<Unit>
    fun hasSession(): Boolean
}