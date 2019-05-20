package com.avgh.bibliotaller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Author
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var db : LibraryDatabase

    private val watcher = Observer<List<Author>>{ data ->
        data.forEach {
            Log.i("test", it.name + it.id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = LibraryDatabase.getDatabase(this)
        val author1 = Author("malex", 1)
        val author2 = Author("romex", 2)
        val author3 = Author("galox", 3)
        val author4 = Author("chik", 2)
        val author5 = Author("afasf", 3)
        db.authorDao().getAuthors().observe(this, watcher)
        GlobalScope.launch {
            delay(1000)
            db.authorDao().insert(author1)
            db.authorDao().insert(author2)
            db.authorDao().insert(author3)
            delay(2000)
            db.authorDao().update(author4)
            db.authorDao().update(author5)
            delay(2000)
            Log.i("test", "Eliminados")
            db.authorDao().delete(author1)
            db.authorDao().delete(author2)
            db.authorDao().delete(author3)
        }

    }
}
