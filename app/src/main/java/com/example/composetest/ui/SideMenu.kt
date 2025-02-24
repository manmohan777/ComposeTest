package com.example.composetest.ui

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@Composable
fun SideMenu(navController: NavController) {
    var menuExpanded by remember { mutableStateOf(false) }
    val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route
    Button(onClick = { menuExpanded = true }) {
        Icon(Icons.Default.Menu, contentDescription = null)
    }
    DropdownMenu(
        expanded = menuExpanded,
        onDismissRequest = { menuExpanded = false },
        modifier = Modifier.fillMaxHeight()
    ) {
        var menues = listOf(
            BottomNavItem.Home,
            BottomNavItem.Wishlist,
            BottomNavItem.Cart,
            BottomNavItem.Search,
            BottomNavItem.Setting
        )
        for (i in menues.indices) {

            DropdownMenuItem(
                text = {
                    Row {
                        Icon(menues[i].icon, contentDescription = null)
                        Text(menues[i].title)
                    }
                },
                onClick = {
                    menuExpanded = false
                    navController.navigate(menues[i].route)
                    // Handle Option 1 action here
                }, modifier = Modifier.background(
                    if (currentRoute == menues[i].route) {
                        Color.Gray
                    } else {
                        Color.White
                    }
                ),
                enabled = currentRoute != menues[i].route
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeftMenuDrawer(navController: NavController) {
    var isDrawerOpen by remember { mutableStateOf(false) } // Track the drawer state
    IconButton(onClick = { isDrawerOpen = true }) {
        Icon(Icons.Default.Menu, contentDescription = null)
    }
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
                var menues = listOf(
                    BottomNavItem.Home,
                    BottomNavItem.Wishlist,
                    BottomNavItem.Cart,
                    BottomNavItem.Search,
                    BottomNavItem.Setting
                )
                for (i in menues.indices) {
                    DrawerItem(menues[i].title) {
                        isDrawerOpen = false
                        navController.navigate(menues[i].route)
                    }
                    Divider(color = Color.Gray, thickness = 1.dp)

                }
            }
        }, drawerState = rememberDrawerState(initialValue = if(isDrawerOpen)DrawerValue.Open else DrawerValue.Closed),
        content = {}
    )

}

@Composable
fun DrawerItem(label: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            textAlign = TextAlign.Start
        )
    }
}

@Preview(showBackground = true)
@Composable
fun drawer() {
    var navController= rememberNavController()
    LeftMenuDrawer(navController)
}
