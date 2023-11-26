package com.example.androidprojekt2

import android.content.Context

fun createMediaMap(): Map<Int, MediaItem> {
    return mapOf(
        0 to MediaItem(
            "Cage the elephant", R.drawable.cte_band,
            "American rock band established in 2006, is renowned for their dynamic mix of alternative, punk, " +
                    "and blues rock. They gained popularity with their hit \"Ain't No Rest for the Wicked\" ",
            createCageTheElephantAlbumList(), createCageTheElephantMembersList()
        ),


        1 to MediaItem("Arctic Monkeys", R.drawable.am, "British rock band formed in 2002 in Sheffield, England, known for their energetic and vibrant indie rock sound. They achieved fame with their debut album \"Whatever People Say I Am, That's What I'm Not," +
                "\" which became the fastest-selling debut album in UK history."
            , createArcticMonkeysAlbumList(), createArcticMonkeysMembersList()
        ),
        2 to MediaItem("Coldplay", R.drawable.c, " British rock band formed in 1996, known for their melodic pop rock, emotive ballads, and expansive anthems. Their hit songs like \"Yellow\" and \"Fix You\" " +
                "have garnered global acclaim, defining them as a mainstay in modern rock and pop music.",
            createColdplayAlbumList(), createColdplayMembersList())
    )
}




fun createCageTheElephantAlbumList(): List<Int>{
    return listOf(R.drawable.cte_unpeeled, R.drawable.cte_2008, R.drawable.cte_thank_you_happy_birthday, R.drawable.cte_malophobia, R.drawable.cte, R.drawable.cte_social_cues)
}

fun createCageTheElephantMembersList(): List<String>{
    return listOf("Matt Shultz", "Lincoln Parish", "Brad „Dave” Shultz", "Jared Champion", "Daniel „Tich” Tichenor", "Matthan Minster", "Nick Bockrath")
}

fun createArcticMonkeysAlbumList(): List<Int>{
    return listOf(R.drawable.am_fluorescent_adolescent, R.drawable.am_teddy_picker, R.drawable.am_humbug, R.drawable.am_cornerstone,
        R.drawable.am_my_propeller, R.drawable.am_suckitandsee, R.drawable.am_am, R.drawable.am_tranquility_base_hotel_casino, R.drawable.am_the_car)
}

fun createArcticMonkeysMembersList(): List<String>{
    return listOf("Alex Turner", "Matt Helders", "Jamie Cook", "Nick O’Malley")
}

fun createColdplayAlbumList(): List<Int>{
    return listOf(R.drawable.c_parachutes, R.drawable.c_a_rush_of_blood, R.drawable.c_x_and_y, R.drawable.c_viva_la_vida,
        R.drawable.c_m_x, R.drawable.c_ghost_stories, R.drawable.c_a_head_full_of_dreams, R.drawable.c_kaleidoskope,
        R.drawable.c_everyday_life, R.drawable.c_music_of_the_spheres)
}

fun createColdplayMembersList() :List<String>{
    return listOf("Chris Martin", "Johny Buckland", "Guy Berryman", "Will Champion")
}