package com.avgh.bibliotaller.repository

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book

class BookRepository(context: Context) {

    val db = LibraryDatabase.getDatabase(context)

    @WorkerThread
    fun insert(book: Book) {
        db.bookDao().insertBook(book)
    }

    fun deleteBook(book: Book) {
        db.bookDao().delete(book)
    }

    fun updateBook(book: Book) {
        db.bookDao().update(book)
    }

    fun getFullBooks(languaje: Int): List<Book> {
        val books = db.bookDao().getBooks()
        books.forEach {
            db.bookJoinAuthorDao().getBookJoinAuthor(it.ISBN).forEach { key ->
                it.author.add(db.authorDao().getAuthor(key.id))
            }
        }
        return books
    }
}