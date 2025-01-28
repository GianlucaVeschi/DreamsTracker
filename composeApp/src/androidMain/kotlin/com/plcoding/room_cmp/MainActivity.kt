package com.plcoding.room_cmp

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plcoding.room_cmp.database.getDreamDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = getDreamDatabase(applicationContext).dreamDao()
        setContent {
            App(dao)
        }
    }
}