package com.roblesdotdev.doa.onboarding.presentation

import androidx.annotation.DrawableRes

data class OnboardingPage(
    val title: String,
    val subtitle: String,
    @DrawableRes val image: Int
)
