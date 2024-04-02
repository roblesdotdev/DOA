package com.roblesdotdev.doa.authentication.domain.usecase

import com.roblesdotdev.doa.authentication.domain.matcher.EmailMatcher

class ValidateEmailUseCase(private val matcher: EmailMatcher) {
    operator fun invoke(email: String): Boolean {
        return matcher.isValid(email)
    }
}