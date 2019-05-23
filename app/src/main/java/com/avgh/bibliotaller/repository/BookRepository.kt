package com.avgh.bibliotaller.repository

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.core.util.set
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

    fun getAllBooks(): LiveData<List<Book>> = db.bookDao().getBooks()

    fun deleteBook(book: Book) {
        db.bookDao().delete(book)
    }

    fun updateBook(book: Book) {
        db.bookDao().update(book)
    }

    fun getBookByIdandLanguaje(ISBN: String, languaje: Int): LiveData<Book>{
        val book = db.bookDao().getBookById(ISBN)
        val join = db.bookJoinAuthorDao().getBookJoinAuthor(ISBN)
        val mUserInfoLiveData = MutableLiveData<Book>()
        book.apply{
            content.set(languaje, db.contentDao().getContent(ISBN, languaje))
            join.forEach{
                this.author.add(db.authorDao().getAuthor(it.authorId))
            }
        }
        mUserInfoLiveData.value = book
        return mUserInfoLiveData
    }

}