package com.example.lettrip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.lettrip.data.FakeSessionRepository
import com.example.lettrip.navigation.AppNavHost
import com.example.lettrip.ui.theme.LetTripTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            LetTripTheme {
                AppNavHost(repository = FakeSessionRepository())
            }
        }
    }
}
