package com.avgh.bibliotaller.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Content

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
