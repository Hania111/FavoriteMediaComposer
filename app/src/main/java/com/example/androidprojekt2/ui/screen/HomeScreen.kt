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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidprojekt2.MediaItem
import com.example.androidprojekt2.R
import com.example.androidprojekt2.ui.FavouriteMediaViewModel
import com.example.androidprojekt2.ui.UserInputEvents


@Composable
fun HomeScreen(navController: NavHostController, favouriteMediaViewModel: FavouriteMediaViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopBar()
        MediaList(mediaMap = createMediaMap(), navController, favouriteMediaViewModel)
    }
}
@Preview
@Composable
fun homeScreenPreview(){
   HomeScreen(rememberNavController(), FavouriteMediaViewModel())
}

@Composable
fun MediaItemComposable(mediaItem: MediaItem, mediaItemId: Int, navController: NavHostController,   favouriteMediaViewModel: FavouriteMediaViewModel) {
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
                painter = painterResource(id = mediaItem.imageName),
                contentDescription = mediaItem.description,
                modifier = Modifier
                    .height(100.dp)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(start = 16.dp)
            ) {
                Text(text = mediaItem.title)
                Text(text = mediaItem.description)
            }
        }
    }

}

@Composable
fun MediaList(mediaMap: Map<Int,MediaItem>, navController: NavHostController,   favouriteMediaViewModel: FavouriteMediaViewModel) {
    LazyColumn {
        items(mediaMap.entries.toList()) { entry ->
            MediaItemComposable(mediaItem = entry.value, mediaItemId = entry.key, navController, favouriteMediaViewModel)
        }
    }
}


fun createMediaMap(): Map<Int, MediaItem> {
    // Sample data with unique keys
    return mapOf(
        0 to MediaItem("Cage The Elephant - Album 1", R.drawable.cte, "description 1"),
        1 to MediaItem("Cage The Elephant - Album 2", R.drawable.cte, "description 2"),
        2 to MediaItem("Cage The Elephant - Album 3", R.drawable.cte, "description 3")
    )
}


