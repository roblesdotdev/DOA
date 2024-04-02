package com.roblesdotdev.doa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.doa.navigation.NavigationHost
import com.roblesdotdev.doa.navigation.NavigationRoute
import com.roblesdotdev.doa.ui.theme.DOATheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DOATheme {
                val navController = rememberNavController()
                NavigationHost(
                    navController = navController,
                    startDestination = getStartDestination()
                )
            }
        }
    }

    private fun getStartDestination(): NavigationRoute {
        return if (viewModel.hasSeenOnboarding) {
            if (viewModel.hasSession) NavigationRoute.Home else NavigationRoute.Login
        } else {
            NavigationRoute.Onboarding
        }
    }
}