package com.example.androidprojekt2.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidprojekt2.ui.FavouriteMediaViewModel

@Composable
fun DescriptionScreen(favouriteMediaViewModel: FavouriteMediaViewModel){
    val selectedMediaItem = favouriteMediaViewModel.uiState.value.selectedMediaItem
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Text(
            text = selectedMediaItem.toString(),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start
        )
    }
}

@Preview
@Composable
fun descriptionScreenPreview(){
    DescriptionScreen(FavouriteMediaViewModel())
}