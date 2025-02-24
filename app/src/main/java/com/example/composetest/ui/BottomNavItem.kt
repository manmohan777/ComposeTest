package com.example.composetest.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object Home : BottomNavItem("Home", Icons.Default.Home, "home")
    object Wishlist : BottomNavItem("Wishlist", Icons.Default.FavoriteBorder, "wishlist")
    object Cart : BottomNavItem("Cart", Icons.Default.ShoppingCart, "cart")
    object Search : BottomNavItem("Search", Icons.Default.Search, "search")
    object Setting : BottomNavItem("Setting", Icons.Default.Settings, "setting")
}
