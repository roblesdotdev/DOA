package com.roblesdotdev.doa

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.doa.navigation.NavigationHost
import com.roblesdotdev.doa.navigation.NavigationRoute
import com.roblesdotdev.doa.onboarding.data.repository.OnboardingRepositoryImpl
import com.roblesdotdev.doa.onboarding.domain.usecase.HasSeenOnboardingUseCase
import com.roblesdotdev.doa.ui.theme.DOATheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DOATheme {
                val navController = rememberNavController()
                val ctx = LocalContext.current
                val sharedPreferences = ctx.getSharedPreferences("doa_app", Context.MODE_PRIVATE)
                val repo = OnboardingRepositoryImpl(sharedPreferences)
                val mainViewModel = MainViewModel(hasSeenOnboardingUseCase = HasSeenOnboardingUseCase(repo))

                NavigationHost(
                    navController = navController,
                    startDestination = getStartDestination(mainViewModel.hasSeenOnboarding)
                )
            }
        }
    }

    private fun getStartDestination(hasSeenOnboarding: Boolean): NavigationRoute {
        return if (hasSeenOnboarding) {
            NavigationRoute.Home
        } else {
            NavigationRoute.Onboarding
        }
    }
}