package com.example.androidprojekt2.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyFavouriteMediaNaviagationGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN){
        composable(Routes.HOME_SCREEN){
            HomeScreen(navController)
        }
        composable(Routes.DESCRIPTION_SCREEN){
            DescriptionScreen()
        }
    }
}