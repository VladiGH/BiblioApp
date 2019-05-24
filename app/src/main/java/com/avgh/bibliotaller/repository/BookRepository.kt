package com.avgh.bibliotaller.repository

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.core.util.set
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.Lagunajes

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
            value?.content?.set(languaje, db.contentDao().getContent(ISBN, languaje))
            join.forEach{
                value?.author?.add(db.authorDao().getAuthor(it.authorId))
            }
        }
        return book
    }


    fun getBooksByLanguaje(languaje: Int):LiveData<List<Book>>{

        val listBook = mutableListOf<Book>()

        var books = db.bookDao().getAllBooks()

        val mBooksLiveData = MutableLiveData<List<Book>>()

        books.forEach{

            it.apply {
                it.content.set(languaje, db.contentDao().getContent(it.ISBN, languaje))

                val Authors = db.bookJoinAuthorDao().getBookJoinAuthor(it.ISBN)
                Authors.forEach{
                    this.author.add(db.authorDao().getAuthor(it.authorId))
                }

                //Falta Editoriales
                //Falta Tags
            }

            listBook.add(it)
        }

        mBooksLiveData.value = listBook
        return mBooksLiveData
    }

}