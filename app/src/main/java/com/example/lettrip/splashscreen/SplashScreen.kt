package com.example.lettrip.splashscreen

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lettrip.R

@Composable
fun SplashScreen(
    state: SplashUiState, onRetry: () -> Unit
) {
    val transition = rememberInfiniteTransition(label = "Logo")
    val pulse by transition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(tween(900), RepeatMode.Reverse),
        label = "pulse"
    )
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(120.dp)
                    .scale(pulse)
            )
            Spacer(modifier = Modifier.height(24.dp))

            when (state) {
                is SplashUiState.Loading -> CircularProgressIndicator(modifier = Modifier.size(28.dp))
                is SplashUiState.Error -> {
                    Text(state.message, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(onClick = onRetry) { Text("Retry") }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SplashShowLoading() {
    MaterialTheme {
        SplashScreen(state = SplashUiState.Loading, onRetry = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SplashShowError() {
    MaterialTheme {
        SplashScreen(state = SplashUiState.Error("Something Went Wrong"), onRetry = {})
    }
}
