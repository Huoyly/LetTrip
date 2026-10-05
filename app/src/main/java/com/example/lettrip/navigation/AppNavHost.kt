package com.example.lettrip.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lettrip.data.SessionRepository
import com.example.lettrip.home.HomeScreen
import com.example.lettrip.splashscreen.SplashRoute

@Composable
fun AppNavHost(repository: SessionRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.SPLASH) {
        composable(Route.SPLASH) {
            SplashRoute(
                repository = repository,
                onNavigateToHome = {
                    navController.navigate(Route.HOME) {
                        popUpTo(Route.SPLASH) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(Route.HOME){
                        popUpTo(Route.SPLASH){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(Route.HOME){
            HomeScreen()
        }
    }
}
