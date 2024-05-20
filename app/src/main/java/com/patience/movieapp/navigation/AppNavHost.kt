package com.patience.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.patience.movieapp.ui.theme.screens.home.HomeScreen
import com.patience.movieapp.ui.theme.screens.login.Loginscreen
import com.patience.movieapp.ui.theme.screens.register.Registration
import com.patience.movieapp.ui.theme.screens.splash.Splash

@Composable
fun AppNavHost(modifier: Modifier =Modifier,
               navController: NavHostController= rememberNavController(),
               startDestination:String= ROUTE_SPLASH) {
    NavHost(
        navController =navController ,
        startDestination =startDestination,
        modifier=modifier) {
        composable(ROUTE_LOGIN){
            Loginscreen(navController )

        }
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_REG) {
           Registration(navController )
        }
        composable(ROUTE_SPLASH) {
          Splash(navController )
        }


    }

}