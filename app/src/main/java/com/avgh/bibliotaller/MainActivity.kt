package com.avgh.bibliotaller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.simpleName
    private lateinit var database: LibraryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = LibraryDatabase.getDatabase(this)
        val maBook = Book("Si funciona 2 veces", "perros", 3)
        GlobalScope.launch {
            try {
                database.bookDao().insertBook(maBook)
            } catch (e: Exception) {
                Log.e(tag, "Vale verga :v")
            }
            val otroBook = database.bookDao().getBooks()
            Log.i(tag, "${otroBook.ISBN} ${otroBook.cover}")
        }
    }
}
