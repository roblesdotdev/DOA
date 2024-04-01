package com.roblesdotdev.doa.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: NavigationRoute,
) {
    NavHost(navController = navController, startDestination = startDestination.route ) {
       composable(NavigationRoute.Onboarding.route) {
           Column {
               Text(text = "Onboarding")
               Button(onClick = {
                   navController.popBackStack()
                   navController.navigate(NavigationRoute.Home.route)
               }) {
                   Text(text = "Get Started")
               }
           }
       }

        composable(NavigationRoute.Home.route) {
            Text(text = "Home screen")
        }
    }
}