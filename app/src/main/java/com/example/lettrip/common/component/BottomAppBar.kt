package com.example.lettrip.common.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.lettrip.ui.theme.EmeraldGreen

data class BottomBarItem(
    val icon: ImageVector,
    val description: String,
    val badgeCount: Int? = null,
    val onClick: () -> Unit
)

@Composable
fun BottomAppBar(
    modifier: Modifier = Modifier,
    item: List<BottomBarItem> = emptyList(),
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = Color.Unspecified,
) {
    val resolvedContentColor = when {
        contentColor != Color.Unspecified -> contentColor
        containerColor == Color.Transparent -> MaterialTheme.colorScheme.onBackground
        containerColor.luminance() > 0.5f -> Color.Black
        else -> Color.White
    }

    BottomAppBar(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = resolvedContentColor,
        actions = {
            item.forEach { item ->
                IconButton(onClick = item.onClick, modifier = Modifier.weight(1f)) {
                    val count = item.badgeCount
                    if (count != null && count > 0) {
                        BadgedBox(badge = { Badge { Text("$count") } }) {
                            Icon(item.icon, contentDescription = item.description)
                        }
                    } else {
                        Icon(item.icon, contentDescription = item.description)
                    }
                }
            }
        })
}

@Preview(showBackground = true, name = "Icon only")
@Composable
private fun PreviewForIcon() {
    MaterialTheme {
        BottomAppBar(
            containerColor = EmeraldGreen, item = listOf(
                BottomBarItem(
                    icon = Icons.Default.Home, description = "Profile", onClick = {}),
                BottomBarItem(
                    icon = Icons.Default.Favorite, description = "Search", onClick = {}),
            )
        )
    }
}
