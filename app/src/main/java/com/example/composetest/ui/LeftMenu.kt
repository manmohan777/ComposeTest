package com.example.composetest.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import com.example.composetest.R

private const val TAG = "LeftMenu"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeftMenu(
    navController: NavController, content: @Composable () -> Unit, title: String
) {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()

    // Drawer content
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(250.dp) // Set drawer width
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Menu",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )

                Divider(color = Color.Gray, thickness = 1.dp)
                val menus = listOf(
                    BottomNavItem.Home,
                    BottomNavItem.Wishlist,
                    BottomNavItem.Cart,
                    BottomNavItem.Search,
                    BottomNavItem.Setting
                )
                for (i in menus.indices) {
                    DrawerItem(label = menus[i].title, icon = menus[i].icon) {
                        navController.navigate(menus[i].route)
                    }
                }

            }
        }, content = {
            Scaffold(topBar = {
                TopAppBar(navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            if (drawerState.isClosed) {
                                drawerState.open()
                            } else {
                                drawerState.close()
                            }
                        }
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = null,
                            modifier = Modifier,
                            contentScale = ContentScale.Fit
                        )
                    }
                }, title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = null,
                                modifier = Modifier,
                                contentScale = ContentScale.Fit
                            )
                        }
                }, actions = {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = null,
                        modifier = Modifier,
                        contentScale = ContentScale.Fit
                    )
                })
            },
                bottomBar = { BottomNavigationBar(navController) }
            ) {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize().background(colorResource(id = R.color.background))
                ) {
                    content()
                }
            }
        }, drawerState = drawerState
    )
}

@Preview(showBackground = true)
@Composable
fun leftMenu() {
    var navController = rememberNavController()
    LeftMenu(navController, {}, "home")
}


