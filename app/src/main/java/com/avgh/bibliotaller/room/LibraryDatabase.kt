package com.avgh.bibliotaller.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.avgh.bibliotaller.room.dao.AuthorDao
import com.avgh.bibliotaller.room.dao.BookDao
import com.avgh.bibliotaller.room.dao.ContentDao
import com.avgh.bibliotaller.room.dao.joinDaos.BookJoinAuthorDao
import com.avgh.bibliotaller.room.entities.*
import com.avgh.bibliotaller.room.entities.joinEntities.BookJoinAuthor
import com.avgh.bibliotaller.room.entities.joinEntities.BookJoinTag

@Database(
    entities = [
        Book::class,
        Content::class,
        Author::class,
        Tag::class,
        Editorial::class,
        BookJoinAuthor::class,
        BookJoinTag::class
    ],
    version = 1,
    exportSchema = false
)
abstract class LibraryDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao
    abstract fun contentDao(): ContentDao
    abstract fun authorDao(): AuthorDao
    abstract fun bookJoinAuthorDao(): BookJoinAuthorDao

    companion object {
        @Volatile
        private var INSTANCE: LibraryDatabase? = null

        fun getDatabase(context: Context): LibraryDatabase {
            val tempInstace = INSTANCE
            if (tempInstace != null) {
                return tempInstace
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibraryDatabase::class.java,
                    "library_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}