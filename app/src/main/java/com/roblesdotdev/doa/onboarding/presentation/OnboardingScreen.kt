package com.roblesdotdev.doa.onboarding.presentation

import androidx.compose.runtime.Composable
import com.roblesdotdev.doa.R
import com.roblesdotdev.doa.onboarding.presentation.components.OnboardingPager

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    val pages = listOf(
        OnboardingPage(
            title = "Welcome to monumental habits",
            subtitle = "We can help you to be a better version on yourselve",
            image = R.drawable.onboarding1,
        ),
        OnboardingPage(
            title = "Create new habits easily",
            subtitle = "We can help you to be a better version on yourselve",
            image = R.drawable.onboarding2,
        ),
        OnboardingPage(
            title = "Keep track of your progress",
            subtitle = "We can help you to be a better version on yourselve",
            image = R.drawable.onboarding3,
        )
    )

    OnboardingPager(pages = pages, onFinish = onFinish)
}