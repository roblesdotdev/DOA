package com.roblesdotdev.doa.onboarding.data.repository

import android.content.SharedPreferences
import com.roblesdotdev.doa.onboarding.domain.repository.OnboardingRepository

class OnboardingRepositoryImpl(
    private val sharedPreferences: SharedPreferences
): OnboardingRepository {
    companion object {
        private const val ONBOARDING_KEY = "shared_onboarding"
    }
    override fun hasSeenOnboarding(): Boolean {
        return sharedPreferences.getBoolean(ONBOARDING_KEY, false)
    }

    override fun completeOnboarding() {
        sharedPreferences.edit().putBoolean(ONBOARDING_KEY, true).apply()
    }
}