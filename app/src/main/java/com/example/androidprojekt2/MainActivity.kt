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
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import com.example.androidprojekt2.ui.theme.AndroidProjekt2Theme
import androidx.navigation.compose.rememberNavController
import com.example.androidprojekt2.ui.screen.Routes
import androidx.navigation.compose.composable
import com.example.androidprojekt2.ui.screen.DescriptionScreen
import com.example.androidprojekt2.ui.screen.HomeScreen
import com.example.androidprojekt2.ui.screen.MyFavouriteMediaNaviagationGraph


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProjekt2Theme {
                myFavouriteMedia()
            }
        }
    }


    @Composable
    fun myFavouriteMedia(){
        MyFavouriteMediaNaviagationGraph()
    }

}

