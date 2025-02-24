package com.example.composetest.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R

@Composable
fun Sponsors() {
    Box(
        contentAlignment = Alignment.CenterStart, modifier = Modifier
            .background(
                colorResource(R.color.primary_bg), shape = RoundedCornerShape(0.dp)
            )
            .height(300.dp)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column() {
            Text("Sponsored", fontSize = 20.sp, modifier = Modifier.padding(0.dp,0.dp,0.dp,5.dp))
            Image(
                painterResource(R.drawable.sponsers), contentDescription = null, contentScale = ContentScale.FillBounds, modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp))
            TextButton({}) {
                Text("up to 50% off", fontSize = 20.sp, color = Color.Black)
                Spacer(Modifier.weight(1f))
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
private fun SponsorPreview() {
    Sponsors()
}