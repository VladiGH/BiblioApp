package com.avgh.bibliotaller.repository

import androidx.annotation.WorkerThread
import com.avgh.bibliotaller.room.dao.BookDao
import com.avgh.bibliotaller.room.entities.Book

class BibliotecaRepository(private val bookDao: BookDao ) {

    @WorkerThread
    fun insert(book: Book){
        bookDao.insertBook(book)
    }

   // fun getAllBooks(): LiveData<List<Book>> = bookDao.getBooks()

    fun deleteBook(book: Book){
        bookDao.delete(book)
    }

    fun updateBook(book: Book){
        bookDao.update(book)
    }



}