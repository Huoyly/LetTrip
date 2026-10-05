package com.example.lettrip.splashscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import com.example.lettrip.data.SessionRepository

@Composable
fun SplashRoute(
    repository: SessionRepository,
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    var uiState by remember { mutableStateOf<SplashUiState>(SplashUiState.Loading) }
    val goHome by rememberUpdatedState(onNavigateToHome)
    val goLogin by rememberUpdatedState(onNavigateToLogin)
    val presenter = remember { SplashPresenter(repository) }

    val view = remember {
        object : SplashContract.View {
            override fun showLoading() {
                uiState = SplashUiState.Loading
            }

            override fun showError(message: String) {
                uiState = SplashUiState.Error(message)
            }

            override fun navigateToHome() = goHome()
            override fun navigateToLogin() = goLogin()

        }
    }
    DisposableEffect(presenter) {
        presenter.attach(view)
        presenter.onViewReady()
        onDispose { presenter.detach() }
    }

    SplashScreen(state = uiState, onRetry = presenter::onRetryClicked)
}
