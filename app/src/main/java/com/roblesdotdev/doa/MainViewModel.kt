package com.roblesdotdev.doa

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roblesdotdev.doa.onboarding.domain.usecase.HasSeenOnboardingUseCase

class MainViewModel(
    private val hasSeenOnboardingUseCase: HasSeenOnboardingUseCase,
) : ViewModel() {
    var hasSeenOnboarding by mutableStateOf(hasSeenOnboardingUseCase())
        private set
}