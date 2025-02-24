package com.example.composetest.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

@Composable
fun DealOfTheDay() {
    val timerConverter = remember {
        mutableStateOf("")
    }
    val lastConnection = remember {
        mutableStateOf(System.currentTimeMillis())
    }
    LaunchedEffect(key1 = timerConverter.value) {
        delay(1000)
        timerConverter.value =
            converting(1000 * 60 * 60 * 12L - (System.currentTimeMillis() - lastConnection.value))
    }

    Box(
        contentAlignment = Alignment.CenterStart, modifier = Modifier
            .background(
                colorResource(R.color.blue_bg), shape = RoundedCornerShape(12.dp)
            )
            .height(100.dp)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row {
            Column() {
                Text("Deal of the day", color = Color.White, fontSize = 20.sp)
                Spacer(modifier = Modifier.size(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(R.drawable.clock),
                        contentDescription = null,
                        tint = Color.White
                        , modifier = Modifier.size(18.dp)
                    )
                    Spacer(Modifier.size(3.dp))
                    Text(timerConverter.value+" remaining", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {}, Modifier.border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                ), colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
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

fun converting(millis: Long): String =
    String.format(
        " %02dh %02dm %02ds",
        TimeUnit.MILLISECONDS.toHours(millis),
        TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
            TimeUnit.MILLISECONDS.toHours(millis)
        ),
        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
            TimeUnit.MILLISECONDS.toMinutes(millis)
        )
    )

@Preview
@Composable
private fun DealOfTheDayPreview() {
    DealOfTheDay()
}