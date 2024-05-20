package com.patience.movieapp.ui.theme.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.patience.movieapp.BottomNavigationBar
import com.patience.movieapp.Popularmovies

import com.patience.movieapp.TopSection

import com.patience.movieapp.ui.theme.TrendingMovies




@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            TopSection()
            Spacer(modifier = Modifier.height(5.dp))


            Text(text = "Popular movies",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(5.dp))
            Popularmovies()

            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Trending shows",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(5.dp))
            TrendingMovies()
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "You're all caught up.",
                fontSize = 19.sp,
                textAlign = TextAlign.Center
                )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Refresh page to load new movies",
                fontSize = 19.sp,
                textAlign = TextAlign.Center,
                color= Color.DarkGray
            )






        }


    }
}

@Preview
@Composable
private fun Homeprev() {
    HomeScreen(navController = rememberNavController())
}