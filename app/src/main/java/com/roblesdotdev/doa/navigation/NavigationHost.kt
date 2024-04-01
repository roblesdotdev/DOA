package com.roblesdotdev.doa.navigation

import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.doa.onboarding.data.repository.OnboardingRepositoryImpl
import com.roblesdotdev.doa.onboarding.domain.usecase.CompleteOnboardingUseCase
import com.roblesdotdev.doa.onboarding.domain.usecase.HasSeenOnboardingUseCase
import com.roblesdotdev.doa.onboarding.presentation.OnboardingScreen
import com.roblesdotdev.doa.onboarding.presentation.OnboardingViewModel

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: NavigationRoute,
) {
    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(NavigationRoute.Onboarding.route) {
            OnboardingScreen(onFinish = {
                navController.popBackStack()
                navController.navigate(NavigationRoute.Home.route)
            })
        }

        composable(NavigationRoute.Home.route) {
            Text(text = "Home screen")
        }
    }
}