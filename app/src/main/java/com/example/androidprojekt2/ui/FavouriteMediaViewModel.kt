package com.example.androidprojekt2.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androidprojekt2.MyMediaItem
import com.example.androidprojekt2.createMediaMap

class FavouriteMediaViewModel : ViewModel(){
    var uiState = mutableStateOf(UserInputState())

    private val mediaMap = createMediaMap()

    fun getMediaItemById(id: Int?): MyMediaItem? {
        return mediaMap[id]
    }

    val myMediaItems: Map<Int, MyMediaItem>
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

