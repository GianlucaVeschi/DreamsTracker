package database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DreamDao {

    @Upsert
    suspend fun upsert(dream: Dream)

    @Delete
    suspend fun delete(dream: Dream)

    @Query("SELECT * FROM dream")
    fun getAllDreams(): Flow<List<Dream>>

}