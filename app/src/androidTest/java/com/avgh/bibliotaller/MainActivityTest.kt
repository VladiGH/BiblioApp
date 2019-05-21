package com.avgh.bibliotaller

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.utilities.BookHolder
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainActivityTest {

    lateinit var instrumentationContext: Context
    lateinit var db: LibraryDatabase

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
        db = LibraryDatabase.getDatabase(instrumentationContext)
    }

    @Test
    fun startDb() {
        assertNull("The database is null", db)
    }

    @Test
    fun insertSomething() {
        val sucRef = arrayOf(0, 0, 0)
        runBlocking {
            for (x: Int in 0..2) {
                val xd = db.bookDao().insertBook(BookHolder.bookHeld[x])
                sucRef[x]= if(xd == Unit) 1 else 2
            }
        }
        assertArrayEquals(arrayOf(1, 1, 1) ,sucRef)
    }

    @Test
    fun getSomeshit() {
        runBlocking {
            db.bookDao().getBooks()
        }
    }
}