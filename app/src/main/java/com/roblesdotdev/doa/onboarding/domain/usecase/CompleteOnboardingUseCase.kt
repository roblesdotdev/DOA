package com.roblesdotdev.doa.onboarding.domain.usecase

import com.roblesdotdev.doa.onboarding.domain.repository.OnboardingRepository

class CompleteOnboardingUseCase(
    private val repository: OnboardingRepository
) {
    operator fun invoke() {
        repository.completeOnboarding()
    }
}