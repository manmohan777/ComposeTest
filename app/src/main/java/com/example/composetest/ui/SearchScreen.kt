package com.example.composetest.ui

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.composetest.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Scaffold(
        topBar = {
            TopAppBar( title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text("Search Screen")
                    }
                })
        }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            Column {
                Text("Search Screen")
                OutlinedTextField(value = "", onValueChange ={
                } )
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.filter), contentDescription = null)
                    Text(text = "manmohan")
                }
            }


        }

    }
}

@Preview
@Composable
fun search() {
    SearchScreen()
}
