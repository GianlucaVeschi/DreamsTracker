package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getDreamDatabase(): DreamDatabase {
    val dbFile = NSHomeDirectory() + "/dream.db"
    return Room.databaseBuilder<DreamDatabase>(
        name = dbFile,
        factory = { DreamDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}