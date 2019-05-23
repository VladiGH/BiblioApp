package com.avgh.bibliotaller.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.test.BookTest
import com.avgh.bibliotaller.utilities.AppConstants
import kotlinx.android.synthetic.main.book_item_layout.*

class BookViewer : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_item_layout)

        var receiver: BookTest = intent?.extras?.getParcelable(AppConstants.BOOK_KEY) ?:BookTest(R.drawable.ic_launcher_background)
        init(receiver)

    }

    fun init(book: BookTest){
        bookImage.setImageResource(book.cover)
    }
}