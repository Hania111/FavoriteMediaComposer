package com.example.androidprojekt2.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidprojekt2.VideoItem
import com.example.androidprojekt2.R
import com.example.androidprojekt2.ui.FavouriteMediaViewModel
import com.example.androidprojekt2.ui.UserInputEvents


@Composable
fun HomeScreen(navController: NavHostController, favouriteMediaViewModel: FavouriteMediaViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopBar(stringResource(R.string.my_favourite_music))
        MediaList(navController, favouriteMediaViewModel)
    }
}


@Composable
fun MediaItemComposable(videoItem: VideoItem, mediaItemId: Int, navController: NavHostController, favouriteMediaViewModel: FavouriteMediaViewModel) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable {
            favouriteMediaViewModel.onEvent(UserInputEvents.SelectedMediaItem(mediaItemId))
            navController.navigate(Routes.DESCRIPTION_SCREEN)
        }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = videoItem.imageName),
                contentDescription = videoItem.description,
                modifier = Modifier
                    .height(100.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = videoItem.title,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }

}

@Composable
fun MediaList(navController: NavHostController, favouriteMediaViewModel: FavouriteMediaViewModel) {
    LazyColumn {
        items(favouriteMediaViewModel.videoItems.entries.toList()) { entry ->
            MediaItemComposable(videoItem = entry.value, mediaItemId = entry.key, navController, favouriteMediaViewModel)
        }
    }
}






