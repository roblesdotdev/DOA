package com.roblesdotdev.doa.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.doa.authentication.presentation.login.LoginScreen
import com.roblesdotdev.doa.authentication.presentation.signup.SignupScreen
import com.roblesdotdev.doa.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: NavigationRoute,
) {
    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(NavigationRoute.Onboarding.route) {
            OnboardingScreen(onFinish = {
                navController.popBackStack()
                navController.navigate(NavigationRoute.Login.route)
            })
        }

        composable(NavigationRoute.Login.route) {
            LoginScreen(onLoginSuccess = {
                navController.popBackStack()
                navController.navigate(NavigationRoute.Home.route)
            }, onSignup = {
                navController.navigate(NavigationRoute.Signup.route)
            })
        }

        composable(NavigationRoute.Signup.route) {
            SignupScreen(onLogin = {
                navController.popBackStack()
            })
        }

        composable(NavigationRoute.Home.route) {
            Text(text = "Home screen")
        }
    }
}