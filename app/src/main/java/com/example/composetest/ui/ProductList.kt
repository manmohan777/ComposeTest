package com.example.composetest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composetest.R
import com.example.composetest.ui.common.ItemCard
import com.example.composetest.ui.common.SortAndFilterSection
import com.example.composetest.ui.home.SearchBar


@Composable
fun ProductList(
    searchTerm: String, modifier: Modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .background(colorResource(id = R.color.background)), navController: NavController
) {
    Box(
        modifier = modifier
    ) {
        Column {
            SearchBar(searchTerm, navController = navController)
            Spacer(Modifier.size(10.dp))
            SortAndFilterSection("52,082+ items")
            ProductListingScreen()
        }
    }

}

@Composable
fun ProductListingScreen() {
    val products = listOf(
        Product(
            "Black Winter Coat",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/coat",
            "$59.99",
            4.5
        ),
        Product(
            "Men's Starry Shirt",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/shirt",
            "$29.99",
            4.2
        ),
        Product(
            "Black Dress",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/dress",
            "$49.99",
            4.7
        ),
        Product(
            "Pink Embroidered Dress",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/pinkdress",
            "$39.99",
            4.3
        ),
        Product(
            "Flare Dress",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/flaredress",
            "$45.99",
            4.6
        ),
        Product(
            "Denim Dress",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/denimdress",
            "$34.99",
            4.4
        ),
        Product(
            "Jordan Stay Sneakers",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/jordan",
            "$79.99",
            4.8
        ),
        Product(
            "Realme 7",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/realme",
            "$199.99",
            4.5
        ),
        Product(
            "Sony PS4",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/ps4",
            "$299.99",
            4.9
        ),
        Product(
            "Black Jacket",
            "Antheaa Black & Rust Orange Floral Print Tiered Midi F...",
            "https://image-url.com/jacket",
            "$69.99",
            4.6
        )
    )
    val counter = remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        // Search Bar

        // Product Grid
        LazyVerticalStaggeredGrid(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            columns = StaggeredGridCells.Adaptive(150.dp)
        ) {

            items(products) { product ->
                if (counter.value%2==0)
                    ItemCard()
                else
                    ItemCard(height=300.dp)

                counter.value++
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(colorResource(R.color.primary_bg)),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(R.drawable.product1),
                contentDescription = product.title,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.title,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = product.desc,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = product.price,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Filled.Star, contentDescription = "Rating", tint = Color.Yellow)
                Text(text = "${product.rating}", fontSize = 14.sp)
            }
        }
    }
}

data class Product(
    val title: String,
    val desc: String,
    val imageUrl: String,
    val price: String,
    val rating: Double
)


@Preview
@Composable
private fun ProductListPreview() {
    val navController = rememberNavController()
    ProductList("", navController = navController)
}