package com.example.composetest.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composetest.R
import com.example.composetest.ui.common.ItemCard
import com.example.composetest.ui.home.DealOfTheDay
import com.example.composetest.ui.home.Faivourates
import com.example.composetest.ui.common.SortAndFilterSection
import com.example.composetest.ui.home.SearchBar
import com.example.composetest.ui.home.NewArrivals
import com.example.composetest.ui.home.OfferCarousel
import com.example.composetest.ui.home.SpecialOffer
import com.example.composetest.ui.home.Sponsors
import com.example.composetest.ui.home.Trending

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(colorResource(id = R.color.background))
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SearchBar(navController =navController )
            Spacer(Modifier.size(10.dp))
            SortAndFilterSection("All Featured")
            Spacer(Modifier.size(10.dp))
            Faivourates()
            Spacer(Modifier.size(10.dp))
            OfferCarousel()
            Spacer(Modifier.size(10.dp))
            DealOfTheDay()
            Spacer(Modifier.size(10.dp))
            LazyRow (content = {
                val ii= listOf(1,2,3,4,5)
                items(ii) {
                    Box(Modifier.padding(horizontal = 5.dp)){
                    ItemCard()
                    }
                }
            })
            Spacer(Modifier.size(10.dp))
            SpecialOffer()
            Spacer(Modifier.size(10.dp))
            Image(painterResource(R.drawable.mac), contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(172.dp), contentScale = ContentScale.FillBounds)
            Spacer(Modifier.size(10.dp))
            Trending()
            Spacer(Modifier.size(10.dp))
            LazyRow (content = {
                val ii= listOf(1,2,3,4,5)
                items(ii) {
                    Box(Modifier.padding(horizontal = 5.dp)){
                        ItemCard()
                    }
                }
            })
            Spacer(Modifier.size(10.dp))
            NewArrivals()
            Spacer(Modifier.size(10.dp))
            Sponsors()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    var navController= rememberNavController()
    HomeScreen(navController = navController)
}

@Preview
@Composable
private fun SpecialOfferPreview() {
    NewArrivals()
}
