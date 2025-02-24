package com.example.composetest.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Wishlist,
        BottomNavItem.Cart,
        BottomNavItem.Search,
        BottomNavItem.Setting
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route

        for (i in items.indices) {
            NavigationBarItem(
                selected = currentRoute == items[i].route,
                onClick = { navController.navigate(items[i].route) },
                icon = { Icon(items[i].icon, contentDescription = items[i].title) },
                label = {
                    if (i == items.size / 2) {
                        Text("")
                    } else {
                        Text(items[i].title)
                    }
                },
                alwaysShowLabel = true,
                modifier = if (i == items.size / 2) {
                    Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)
                } else {
                    Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)
                }
            )
        }
    }
}
