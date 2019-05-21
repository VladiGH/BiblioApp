package com.avgh.bibliotaller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.room.entities.Content
import kotlinx.coroutines.delay
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var database: LibraryDatabase
    private val observer = Observer<List<Content>>{
            data ->
        data.forEach {
            Log.i("test", it.title + it.resume +it.bookId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
