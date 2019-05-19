package com.avgh.bibliotaller

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.lang.Exception

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : LifecycleOwner {
    override fun getLifecycle(): Lifecycle {
        return LifecycleRegistry(this)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.avgh.bibliotaller", appContext.packageName)
    }


    @Test
    fun insertBooks() {
        var resultOfTest = false
        val database = LibraryDatabase.getDatabase(InstrumentationRegistry.getTargetContext())
        val maBook1 = Book("ABCDE", "someURL", 3)
        val maBook2 = Book("FGHIJ", "someURL2", 25)
        val maBook3 = Book("KLMNO", "someURL3", 10)
        GlobalScope.launch {
            try {
                database.bookDao().insertBook(maBook1)
                database.bookDao().insertBook(maBook2)
                database.bookDao().insertBook(maBook3)
                resultOfTest = true
            } catch (e: Exception) {
            }
            assert(resultOfTest)
        }
    }

    @Test
    fun readBook() {
        val database = LibraryDatabase.getDatabase(InstrumentationRegistry.getTargetContext())
        GlobalScope.launch {
            val libros = database.bookDao().getBooks()
            val bookReader = Observer<List<Book>>{
                    lista ->
                val resul = Array(3){ it == 1 }
                resul[0] = lista[0].ISBN == "ABCDE"
                resul[1] = lista[1].ISBN == "FGHIJ"
                resul[2] = lista[2].ISBN == "KLMNO"
                assertArrayEquals("Resultado de leer libros", arrayOf(true, true, true),resul)
            }
            libros.observe(this@ExampleInstrumentedTest, bookReader)

        }
    }
}
