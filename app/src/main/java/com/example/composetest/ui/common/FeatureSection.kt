package com.example.composetest.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.R

@Composable
fun SortAndFilterSection(text:String="") {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = text)
        Spacer(modifier = Modifier.weight(1f))
        Button(
            shape = RoundedCornerShape(20.dp),
            onClick = { /*TODO*/ }, modifier = Modifier
                .padding(2.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(text = "Sort", color = Color.Black)
            Spacer(Modifier.size(1.dp))
            Image(
                painter = painterResource(id = R.drawable.sort),
                contentDescription = null
            )
        }
        Button(
            shape = RoundedCornerShape(20.dp),
            onClick = { /*TODO*/ }, modifier = Modifier
                .padding(2.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(text = "Filter", color = Color.Black)
            Spacer(Modifier.size(1.dp))
            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun FeaturesPreview() {
    SortAndFilterSection()
}