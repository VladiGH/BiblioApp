package com.avgh.bibliotaller.repository

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book

class BookRepository(context: Context) {

    val db = LibraryDatabase.getDatabase(context)

    @WorkerThread
    fun insert(book: Book) {
        db.bookDao().insertBook(book)
    }

    fun getAllBooks(): LiveData<List<Book>> = db.bookDao().getBooks()

    fun deleteBook(book: Book) {
        db.bookDao().delete(book)
    }

    fun updateBook(book: Book) {
        db.bookDao().update(book)
    }


}