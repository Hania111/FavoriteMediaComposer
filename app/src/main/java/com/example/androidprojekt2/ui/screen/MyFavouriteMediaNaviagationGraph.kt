package com.example.androidprojekt2.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidprojekt2.ui.FavouriteMediaViewModel

@Composable
fun MyFavouriteMediaNaviagationGraph(favouriteMediaViewModel: FavouriteMediaViewModel = viewModel()){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN){
        composable(Routes.HOME_SCREEN){
            HomeScreen(navController, favouriteMediaViewModel)
        }
        composable(Routes.DESCRIPTION_SCREEN){
            DescriptionScreen(favouriteMediaViewModel)
        }
    }
}