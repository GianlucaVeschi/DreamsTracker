package com.plcoding.room_cmp.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.DreamDatabase

fun getDreamDatabase(context: Context): DreamDatabase {
    val dbFile = context.getDatabasePath("dream.db")
    return Room.databaseBuilder<DreamDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}