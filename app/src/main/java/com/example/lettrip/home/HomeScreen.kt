package com.example.lettrip.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lettrip.common.component.ToolAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "Home Screen")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            ToolAppBar(
                titleBar = "Home",
                leftIcon = Icons.Default.Person,
                rightIcon = Icons.Default.Search,
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text("Welcome to Home", style = MaterialTheme.typography.headlineSmall)
        }
    }
}
