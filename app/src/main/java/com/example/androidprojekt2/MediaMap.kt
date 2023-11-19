package com.example.androidprojekt2

fun createMediaMap(): Map<Int, MediaItem> {
    // Sample data with unique keys
    return mapOf(
        0 to MediaItem("Cage The Elephant - Album 1", R.drawable.cte, "description 1", createAlbumsList(), createLineUpList()),
        1 to MediaItem("Cage The Elephant - Album 2", R.drawable.cte, "description 2", createAlbumsList(), createLineUpList()),
        2 to MediaItem("Cage The Elephant - Album 3", R.drawable.cte, "description 3", createAlbumsList(), createLineUpList())
    )
}

fun createAlbumsList(): List<Int>{
    return listOf (R.drawable.cte, R.drawable.cte, R.drawable.cte, R.drawable.cte)
}

fun createLineUpList(): List<String>{
    return listOf ("człowiek 1", "człowiek 2")
}