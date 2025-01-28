package database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dream(
    val name: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
