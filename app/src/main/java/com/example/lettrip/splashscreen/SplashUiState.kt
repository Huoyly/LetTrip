package com.example.lettrip.splashscreen

sealed interface SplashUiState {
    data object Loading : SplashUiState
    data class Error(val message: String): SplashUiState
}
