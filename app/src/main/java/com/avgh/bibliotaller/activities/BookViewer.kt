package com.avgh.bibliotaller.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.avgh.bibliotaller.R
import com.avgh.bibliotaller.test.BookTest
import kotlinx.android.synthetic.main.book_item_layout.*

class BookViewer : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_item_layout)

        val mIntent = intent

        if(mIntent!=null){

            var receiver: BookTest = intent?.extras?.getParcelable("COIN") ?:BookTest(
                R.drawable.ic_launcher_background)

            Log.d("Image URL: ", "Recibiendo: $receiver")

            init(receiver)

        }

    }

    fun init(book: BookTest){
        bookImage.setImageResource(book.cover)
    }


}