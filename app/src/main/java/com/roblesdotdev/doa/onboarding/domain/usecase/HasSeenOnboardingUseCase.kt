package com.roblesdotdev.doa.onboarding.domain.usecase

import com.roblesdotdev.doa.onboarding.domain.repository.OnboardingRepository

class HasSeenOnboardingUseCase(
    private val repository: OnboardingRepository
) {
    operator fun invoke(): Boolean {
        return repository.hasSeenOnboarding()
    }
}