package nelson.rsfred.hubapp.di

import androidx.room.Room
import nelson.rsfred.hubapp.data.database.NOFHPDatabase
import org.koin.dsl.module
import nelson.rsfred.hubapp.data.repository.HighScoreRepository
import nelson.rsfred.hubapp.data.repository.TopicRepository

private const val DB_NAME = "nofhp_quiz_db"

val dataModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = NOFHPDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<NOFHPDatabase>().highScoreDao() }

    single {
        HighScoreRepository(
            highScoreDao = get(),
            coroutineDispatcher = get(DispatchersQualifiers.IO)
        )
    }

    single { TopicRepository() }
}