package com.example.composetest.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composetest.ui.HomeScreen
import com.example.composetest.ui.CartScreen
import com.example.composetest.ui.LeftMenu
import com.example.composetest.ui.ProductList
import com.example.composetest.ui.SearchScreen
import com.example.composetest.ui.SettingScreen
import com.example.composetest.ui.WishlistScreen
import kotlinx.coroutines.CoroutineScope


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            LeftMenu(
                navController = navController,
                content = {HomeScreen(navController=navController)}, "Home"
            )
        }
        composable("search") {
            LeftMenu(
                navController = navController,
                content = { SearchScreen() }, "Search"
            )
        }
        composable("cart") {
            LeftMenu(
                navController = navController,
                content = { CartScreen() }, "Cart"
            )
        }
        composable("wishlist") {
            LeftMenu(
                navController = navController,
                content = { WishlistScreen() }, "WishList"
            )
        }
        composable("setting") {
            LeftMenu(
                navController = navController,
                content = { SettingScreen() }, "Settings"
            )
        }
        composable("productList/{searchTerm}", arguments = listOf(
            navArgument("searchTerm") {
                type = NavType.StringType
            })) {entry->
            val searchTerm = entry.arguments?.getString("searchTerm") ?: ""
            LeftMenu(
                navController = navController,
                content = { ProductList(searchTerm, navController = navController) }, "Products"
            )
        }
    }
}
