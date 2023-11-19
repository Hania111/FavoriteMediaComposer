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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidprojekt2.MediaItem
import com.example.androidprojekt2.R


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "My Favorite Media",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        MediaList(mediaList = createMediaList(), navController)
    }
}
@Preview
@Composable
fun homeScreenPreview(){
   HomeScreen(rememberNavController())
}

@Composable
fun MediaItemComposable(mediaItem: MediaItem, navController: NavHostController) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable {
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
fun MediaList(mediaList: List<MediaItem>, navController: NavHostController) {
    LazyColumn {
        items(mediaList) { mediaItem ->
            MediaItemComposable(mediaItem = mediaItem, navController)
        }
    }
}

fun createMediaList():List<MediaItem>{
    return listOf(
        MediaItem("Cage The elephant", R.drawable.cte, "description 1"),
        MediaItem("Cage The elephant", R.drawable.cte, "descritpion 2"),
        MediaItem("Cage The elephant", R.drawable.cte, "description 3")
    )
}

