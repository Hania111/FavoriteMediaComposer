package com.example.androidprojekt2

data class MyMediaItem(
    val title: String,
    val imageName: Int,
    val description: String,
    val albumList : List<Int>,
    val lineUpList: List<String>,
    val videoUrls : List<String>
)
