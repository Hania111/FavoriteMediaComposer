package com.example.androidprojekt2.ui

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.contentValuesOf
import androidx.lifecycle.ViewModel
import com.example.androidprojekt2.MediaItem
import com.example.androidprojekt2.createMediaMap

class FavouriteMediaViewModel : ViewModel(){
    var uiState = mutableStateOf(UserInputState())

    private val mediaMap = createMediaMap()

    fun getMediaItemById(id: Int?): MediaItem? {
        return mediaMap[id]
    }

    val mediaItems: Map<Int, MediaItem>
        get() = mediaMap

    fun onEvent(event: UserInputEvents){
        when (event){
            is UserInputEvents.SelectedMediaItem ->{
                uiState.value = uiState.value.copy(
                    selectedMediaItem = event.mItem
                )
            }
        }
    }
}

data class UserInputState(
    var  selectedMediaItem: Int = 0
)

sealed class UserInputEvents {
    data class SelectedMediaItem(val mItem: Int) : UserInputEvents()
}

