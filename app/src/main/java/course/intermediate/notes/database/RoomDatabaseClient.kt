package course.intermediate.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import course.intermediate.notes.models.*

const val DATABASE_SCHEMA_VERSION = 1
const val DB_NAME = "local-db"

@Database(version = DATABASE_SCHEMA_VERSION, entities = [Tag::class, Note::class, TaskEntity::class, Todo::class])
abstract class RoomDatabaseClient : RoomDatabase() {

    // Insert DAOs below
    abstract fun noteDAO(): NoteDAO

    companion object {

        private var instance: RoomDatabaseClient? = null

        fun getInstance(context: Context): RoomDatabaseClient {

            if (instance == null) {
                //create instance
                instance = createDatabase(context)
            }
            return instance!!
        }

        private fun createDatabase(context: Context): RoomDatabaseClient {

            return Room.databaseBuilder(context, RoomDatabaseClient::class.java, DB_NAME).build()

        }
    }
}