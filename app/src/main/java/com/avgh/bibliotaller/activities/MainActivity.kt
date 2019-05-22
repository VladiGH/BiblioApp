package com.avgh.bibliotaller.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Content
import com.avgh.bibliotaller.fragments.BookListFragment
import com.avgh.bibliotaller.test.BookTest

class MainActivity : AppCompatActivity(), BookListFragment.OnFragmentInteractionListener {

    override fun onClick(){

    }

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

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val books = ArrayList<BookTest>()

        books.add(BookTest(R.drawable.murmullo))
        books.add(BookTest(R.drawable.creatividad))
        books.add(BookTest(R.drawable.nuestro_planeta))
        books.add(BookTest(R.drawable.portada_la))
        books.add(BookTest(R.drawable.portada_yo_julia))
        books.add(BookTest(R.drawable.creatividad))
        books.add(BookTest(R.drawable.murmullo))
        books.add(BookTest(R.drawable.portada_la))
        books.add(BookTest(R.drawable.nuestro_planeta))
        books.add(BookTest(R.drawable.portada_yo_julia))

        val adapter = BookAdapter(books)

        recyclerView.adapter = adapter
    }

}
