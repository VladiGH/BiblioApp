package com.avgh.bibliotaller.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.forEach
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.room.entities.Author
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.room.entities.Content
import com.avgh.bibliotaller.utilities.AppConstants
import com.avgh.bibliotaller.utilities.Languages
import kotlinx.android.synthetic.main.book_item_layout.*
import kotlinx.android.synthetic.main.fragment_book_detail.*

class BookViewer : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_book_detail)

        val receiver = intent?.extras?.getParcelable(AppConstants.BOOK_KEY) ?:Book(R.string.n_a_value.toString(), R.drawable.ic_launcher_background.toString(), 1, false)
        intent?.extras?.getParcelableArrayList<Author>(AppConstants.AUTHOR_KEY)?.forEach {
            receiver.author.add(it)
        }
        intent?.extras?.getSparseParcelableArray<Content>(AppConstants.CONTENT_KEY)?.forEach { key, value ->
            receiver.content.put(key, value)
        }
        Log.d("MainActivity", receiver.toString())
        init(receiver)

    }

    fun init(book: Book){
        bookISBN.text = book.ISBN
        bookEdition.text = book.edition.toString()
        land_book_image.setImageResource(book.cover.toInt())
        bookAuthor.text = book.author[0].name
        bookSummary.text = book.content.get(Languages.ENGLISH).resume
        bookTitle.text = book.content.get(Languages.ENGLISH).title
    }
}