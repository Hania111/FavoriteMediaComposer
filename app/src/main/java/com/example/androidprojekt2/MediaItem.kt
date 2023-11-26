package com.example.androidprojekt2

data class MediaItem(
    val title: String,
    val imageName: Int,
    val description: String,
    val albumList : List<Int>,
    val lineUpList: List<String>)
