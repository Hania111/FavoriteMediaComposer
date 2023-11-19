package com.example.androidprojekt2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidprojekt2.ui.theme.AndroidProjekt2Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProjekt2Theme {
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Add a Text Composable for the title
                    Text(
                        text = "My Favorite Media",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    MediaList(mediaList = createMediaList())

                }
            }
        }
    }
}

@Composable
fun MediaItemComposable(mediaItem: MediaItem) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
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
fun MediaList(mediaList: List<MediaItem>) {
    LazyColumn {
        items(mediaList) { mediaItem ->
            MediaItemComposable(mediaItem = mediaItem)
        }
    }
}

fun createMediaList():List<MediaItem>{
    return listOf(MediaItem("Cage The elephant", R.drawable.cte, "really great album"),
        MediaItem("Cage The elephant", R.drawable.cte, "really great album"),
        MediaItem("Cage The elephant", R.drawable.cte, "really great album"))
}
