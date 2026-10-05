package com.example.lettrip.common.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.lettrip.ui.theme.EmeraldGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolAppBar(
    titleBar: String,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
    leftIcon: ImageVector? = null,
    onLeftClick: () -> Unit = {},
    leftDescription: String? = null,
    rightIcon: ImageVector? = null,
    onRightClick: () -> Unit = {},
    rightDescription: String? = null,
    rightBadgeCount: Int? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    val resolvedContentColor = when {
        contentColor != Color.Unspecified -> contentColor
        containerColor == Color.Transparent -> MaterialTheme.colorScheme.onBackground
        containerColor.luminance() > 0.5f -> Color.Black
        else -> Color.White
    }

    CenterAlignedTopAppBar(
        modifier = modifier, title = {
            Text(
                text = titleBar,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }, navigationIcon = {
            if (leftIcon != null) {
                BarIconButton(leftIcon, leftDescription, null, onLeftClick)
            }
        }, actions = {
            if (rightIcon != null) {
                BarIconButton(rightIcon, rightDescription, rightBadgeCount, onRightClick)
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            scrolledContainerColor = containerColor,
            titleContentColor = resolvedContentColor,
            navigationIconContentColor = resolvedContentColor,
            actionIconContentColor = resolvedContentColor
        ), scrollBehavior = scrollBehavior
    )
}

@Composable
private fun BarIconButton(
    icon: ImageVector, description: String?, badgeCount: Int?, onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        if (badgeCount != null && badgeCount > 0) {
            BadgedBox(badge = { Badge { Text("$badgeCount") } }) {
                Icon(imageVector = icon, contentDescription = description)
            }
        } else {
            Icon(imageVector = icon, contentDescription = description)
        }
    }
}

// ---------------- Previews ----------------
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "Left + Right")
@Composable
private fun BothIconPreview() {
    MaterialTheme {
        ToolAppBar(
            titleBar = "Home",
            leftIcon = Icons.Default.Person,
            rightIcon = Icons.Default.Search,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "Left only")
@Composable
private fun LeftIconPreview() {
    MaterialTheme {
        ToolAppBar(
            titleBar = "Home",
            leftIcon = Icons.Default.Person,
            rightIcon = null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "Right only")
@Composable
private fun RightIconPreview() {
    MaterialTheme {
        ToolAppBar(
            titleBar = "Home",
            leftIcon = null,
            rightIcon = Icons.Default.Search,
            containerColor = EmeraldGreen
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "No Icon")
@Composable
private fun NoIconPreview() {
    MaterialTheme {
        ToolAppBar(
            titleBar = "Home",
            leftIcon = null,
            rightIcon = null,
            containerColor = Color.Transparent
        )
    }
}
