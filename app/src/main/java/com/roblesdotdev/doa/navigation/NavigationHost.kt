package com.roblesdotdev.doa.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.doa.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: NavigationRoute,
) {
    NavHost(navController = navController, startDestination = startDestination.route ) {
       composable(NavigationRoute.Onboarding.route) {
           OnboardingScreen() {
               navController.popBackStack()
               navController.navigate(NavigationRoute.Home.route)
           }
       }

        composable(NavigationRoute.Home.route) {
            Text(text = "Home screen")
        }
    }
}