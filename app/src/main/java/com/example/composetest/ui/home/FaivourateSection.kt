package com.example.composetest.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.R
import com.example.composetest.model.FeatoredCategories

@Composable
fun Faivourates() {
    LazyRow(content = {
        val list = listOf(
            FeatoredCategories(R.drawable.beauty, "Beauty"),
            FeatoredCategories(R.drawable.fashion, "Fashion"),
            FeatoredCategories(R.drawable.kids, "Kids"),
            FeatoredCategories(R.drawable.mens, "Men"),
            FeatoredCategories(R.drawable.womens, "Women"),
            FeatoredCategories(R.drawable.fashion, "Roadster"),
        )
        items(list) { currentCategory ->
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(5.dp)) {
                Image(
                    painter = painterResource(id = currentCategory.id),
                    contentDescription = currentCategory.name, Modifier.size(56.dp)
                )
                Text(
                    text = currentCategory.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
            }
        }

    }
    )
}

@Preview
@Composable
private fun FaivouratesPreview() {
    Faivourates()

}