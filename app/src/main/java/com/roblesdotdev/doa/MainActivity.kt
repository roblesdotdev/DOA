package com.roblesdotdev.doa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.doa.navigation.NavigationHost
import com.roblesdotdev.doa.navigation.NavigationRoute
import com.roblesdotdev.doa.ui.theme.DOATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DOATheme {
                val navController = rememberNavController()
                NavigationHost(
                    navController = navController,
                    startDestination = NavigationRoute.Onboarding
                )
            }
        }
    }
}