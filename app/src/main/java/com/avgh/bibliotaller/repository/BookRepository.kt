package com.avgh.bibliotaller.repository

import android.content.Context
import androidx.annotation.WorkerThread
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

    fun getFullBooks(language: Int): List<Book> {
        val books = db.bookDao().getBooks()
        books.forEach {
            db.bookJoinAuthorDao().getBookJoinAuthor(it.ISBN).forEach { key ->
                it.author.add(db.authorDao().getAuthor(key.id))
            }
            it.content.put(language, db.contentDao().getContent(it.ISBN, language))
        }
        return books
    }
}