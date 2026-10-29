package nelson.rsfred.hubapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import nelson.rsfred.hubapp.data.database.dao.HighScoreDao
import nelson.rsfred.hubapp.data.database.converter.Converters
import nelson.rsfred.hubapp.data.entity.HighScore

@Database(
    entities = [HighScore::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class NOFHPDatabase : RoomDatabase() {

    abstract fun highScoreDao(): HighScoreDao
}

