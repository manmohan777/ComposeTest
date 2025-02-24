package com.example.composetest.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R

@Composable
fun SpecialOffer() {
    Box(
        contentAlignment = Alignment.CenterStart, modifier = Modifier
            .background(
                colorResource(R.color.primary_bg), shape = RoundedCornerShape(12.dp)
            )
            .height(100.dp)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(R.drawable.special_offer), contentDescription = null,
                Modifier.size(75.dp,60.dp))
            Spacer(Modifier.size(5.dp))
            Column {
                Text("Special Offer \uD83D\uDE31 ", fontSize = 16.sp)
                Text("We make sure you get the offer you need at best prices", fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
private fun SpecialOfferPreview() {
    SpecialOffer()
}