package com.example.lettrip.home

import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lettrip.common.component.BottomAppBar
import com.example.lettrip.common.component.BottomBarItem
import com.example.lettrip.common.component.ToolAppBar
import com.example.lettrip.ui.theme.EmeraldGreen

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
                containerColor = EmeraldGreen
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = EmeraldGreen,
                item = listOf(
                    BottomBarItem(
                        icon = Icons.Default.Home, description = "Home", onClick = {}
                    ),
                    BottomBarItem(
                        icon = Icons.Default.ShoppingCart, description = "Cart", onClick = {}
                    ),
                    BottomBarItem(
                        icon = Icons.Default.Favorite, description = "Favorite", onClick = {}
                    ),
                )
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
