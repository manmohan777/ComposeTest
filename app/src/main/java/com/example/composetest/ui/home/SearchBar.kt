package com.example.composetest.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest.R

@Composable
fun SearchBar(text:String="",navController: NavController) {
    var searchText by remember {
        mutableStateOf(text)
    }

    TextField( keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done,),
        keyboardActions = KeyboardActions(
            onDone = {
                navController.navigate("productList/$searchText")
            }
        ),
        shape = RoundedCornerShape(10.dp), value = searchText, leadingIcon = {
        Image(
            painterResource(id = R.drawable.search),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
    }, trailingIcon = {
        Image(
            painterResource(id = R.drawable.mike),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
    }, placeholder = {
        Text(text = "Search Any Product")
    },
        onValueChange = {
            searchText = it
            if(searchText.length>4)
                navController.navigate("productList/$searchText")
        },
        modifier = Modifier
            .fillMaxWidth(),
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledPrefixColor = Color.Transparent,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.Gray,
            errorContainerColor = Color.Red,
        )
    )
}