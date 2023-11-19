package com.example.androidprojekt2.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidprojekt2.MediaItem
import com.example.androidprojekt2.R
import com.example.androidprojekt2.ui.FavouriteMediaViewModel

@Composable
fun DescriptionScreen(favouriteMediaViewModel: FavouriteMediaViewModel){
    val selectedMediaItemId = favouriteMediaViewModel.uiState.value.selectedMediaItem
    val selectedMediaItem = favouriteMediaViewModel.getMediaItemById(selectedMediaItemId)
    var selectedTabIndex by remember { mutableStateOf(0) }


    Column(modifier = Modifier.fillMaxWidth()) {

        TopBar(selectedMediaItem?.title ?: "No media selected")

        selectedMediaItem?.let { RowPhotoDescription(mediaItem = selectedMediaItem)}

        MediaTabs(selectedTabIndex = selectedTabIndex, updateTabIndex = { newTabIndex ->
            selectedTabIndex = newTabIndex
        })

        when (selectedTabIndex) {
            0 -> selectedMediaItem?.albumList?.let { albumList -> AlbumsGrid(albumList) }
            1 -> selectedMediaItem?.lineUpList?.let { lineUpList -> LineUpList(lineUpList) }
        }
    }

}


@Composable
fun RowPhotoDescription(mediaItem : MediaItem){
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = mediaItem.imageName) ,
            contentDescription = "Description",
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
        )
        Text(
            text = mediaItem.description,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun MediaTabs(selectedTabIndex: Int, updateTabIndex: (Int) -> Unit) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        Tab(selected = selectedTabIndex == 0, onClick = { updateTabIndex(0) }) {
            Text("ALBUMS")
        }
        Tab(selected = selectedTabIndex == 1, onClick = { updateTabIndex(1) }) {
            Text("LINE-UP")
        }
    }
}


@Composable
fun AlbumsGrid(albumList: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 3),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(albumList) { albumImageResId ->
            Image(
                painter = painterResource(id = albumImageResId),
                contentDescription = "Album Image",
                modifier = Modifier
                    .height(100.dp)
                    .padding(1.dp)
            )
        }
    }
}


@Composable
fun LineUpList(lineUpList: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight()
    ) {
        items(lineUpList) { lineUpItem ->
            Text(
                text = lineUpItem,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}



@Preview
@Composable
fun descriptionScreenPreview(){
    DescriptionScreen(FavouriteMediaViewModel())
}

