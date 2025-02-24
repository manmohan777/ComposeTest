package com.example.composetest.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R

@Composable
fun NewArrivals() {
    Box(
        contentAlignment = Alignment.CenterStart, modifier = Modifier
            .background(
                colorResource(R.color.primary_bg), shape = RoundedCornerShape(12.dp)
            )
            .height(300.dp)
            .fillMaxWidth()
    ) {
        Column(Modifier.fillMaxSize()) {
            Image(
                painterResource(R.drawable.new_arrivals), contentDescription = null, contentScale = ContentScale.FillBounds, modifier = Modifier
                .fillMaxWidth()
                .height(200.dp))
            Row (modifier = Modifier.padding(10.dp)){
                Column() {
                    Text("New Arrivals", fontSize = 20.sp)
                    Spacer(modifier = Modifier.size(10.dp))
                    Text("Summer' 25 Collection")
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {}, Modifier.background(
                        color = colorResource(R.color.pink_bg),
                        shape = RoundedCornerShape(10.dp)
                    ), colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.pink_bg))
                ) {
                    Text("View All", color = Color.White)
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color.White, modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}