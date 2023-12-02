package com.example.androidprojekt2.ui.screen

import android.app.ActionBar
import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
//import androidx.media3.ui.PlayerView
//import com.example.androidprojekt2.MediaItem
import com.example.androidprojekt2.R
import com.example.androidprojekt2.VideoItem
import com.example.androidprojekt2.ui.FavouriteMediaViewModel




@Composable
fun DescriptionScreen(favouriteMediaViewModel: FavouriteMediaViewModel){
    val selectedMediaItemId = favouriteMediaViewModel.uiState.value.selectedMediaItem
    val selectedMediaItem = favouriteMediaViewModel.getMediaItemById(selectedMediaItemId)
    var selectedTabIndex by remember { mutableStateOf(0) }


    Column(modifier = Modifier.fillMaxWidth()) {

        TopBar(selectedMediaItem?.title ?: stringResource(R.string.no_media_selected))

        selectedMediaItem?.let { RowPhotoDescription(mediaItem = selectedMediaItem)}

        Spacer(modifier = Modifier.height(16.dp))

        MediaTabs(selectedTabIndex = selectedTabIndex, updateTabIndex = { newTabIndex ->
            selectedTabIndex = newTabIndex
        })

        when (selectedTabIndex) {
            0 -> selectedMediaItem?.albumList?.let { albumList -> AlbumsGrid(albumList) }
            1 -> selectedMediaItem?.lineUpList?.let { lineUpList -> MembersList(lineUpList) }
            2 -> PlayVideo()
        }
    }

}


@Composable
fun RowPhotoDescription(mediaItem : VideoItem){
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = mediaItem.imageName) ,
            contentDescription = stringResource(R.string.description),
            modifier = Modifier
                .size(150.dp)
                .padding(12.dp)
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
            Text(stringResource(R.string.albums))
        }
        Tab(selected = selectedTabIndex == 1, onClick = { updateTabIndex(1) }) {
            Text(stringResource(R.string.members))
        }
        Tab(selected = selectedTabIndex == 2, onClick = { updateTabIndex(2) }) {
            Text("VIDEO")
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
                contentDescription = stringResource(R.string.album_image),
                modifier = Modifier
                    .padding(0.dp)
                    .aspectRatio(1f, true),

            )
        }
    }
}


@Composable
fun MembersList(lineUpList: List<String>) {
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



//@Composable
//fun PlayVideo(context : Context){
//    val videoUrl = "https://www.youtube.com/watch?v=n95eekfFZZg"
//    val exoPlayer = remember(context){
//        SimpleExoPlayer.Builder(context).build().apply {
//            val dataSourceFactory : DataSource.Factory = DefaultDataSourceFactory(context,
//                Util.getUserAgent(context, context.packageName))
//
//            val source = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(videoUrl))
//
//            this.prepare(source)
//        }
//    }
//
////    AndroidView(
////        factory = { ctx ->
////            PlayerView(ctx).apply {
////                layoutParams = ActionBar.LayoutParams(MATCH_PARENT, MATCH_PARENT)
////                player = exoPlayer
////            }
////        },
////        update = { view ->
////            view.player = exoPlayer
////        }
////    )
//    AndroidView(factory = {context ->
//        PlayerView(context).apply {
//            player = exoPlayer
//        }
//
//    })
//
//
//}

@Composable
fun PlayVideo() {
    val context = LocalContext.current
    val videoUrl = "android.resource://${context.packageName}/raw/nr"
    val exoPlayer = remember(context) {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
        }
    }

    AndroidView(factory = { context ->
        PlayerView(context).apply {
            player = exoPlayer
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
    }, update = { view ->
        view.player = exoPlayer
        view.onResume()
    })

    DisposableEffect(exoPlayer) {
        onDispose {
            exoPlayer.release()
        }
    }
}


//@Preview
//@Composable
//fun descriptionScreenPreview(){
//    DescriptionScreen(FavouriteMediaViewModel())
//}

