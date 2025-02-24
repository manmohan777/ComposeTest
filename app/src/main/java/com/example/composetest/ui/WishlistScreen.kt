package com.example.composetest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen() {
    Scaffold(
        topBar = {
            TopAppBar( title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text("Wishlist Screen")
                    }
                })
        }
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(it)) {

                Text("Wishlist Screen")

        }
    }
}
