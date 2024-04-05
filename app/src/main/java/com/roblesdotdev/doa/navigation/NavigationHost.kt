package com.roblesdotdev.doa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.roblesdotdev.doa.authentication.presentation.login.LoginScreen
import com.roblesdotdev.doa.authentication.presentation.signup.SignupScreen
import com.roblesdotdev.doa.habits.presentation.detail.DetailScreen
import com.roblesdotdev.doa.habits.presentation.home.HomeScreen
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
            }, onSignIn = {
                navController.popBackStack()
                navController.navigate(NavigationRoute.Home.route)
            })
        }

        composable(NavigationRoute.Home.route) {
            HomeScreen(onCreateAction = {
                navController.navigate(NavigationRoute.Detail.route)
            }, onEditHabit = { habitId ->
                navController.navigate(NavigationRoute.Detail.route + "?habitId=$habitId")
            })
        }

        composable(NavigationRoute.Detail.route + "?habitId={habitId}", arguments = listOf(
            navArgument("habitId") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )) {
            DetailScreen(onBack = { navController.popBackStack() })
        }
    }
}