package com.avgh.bibliotaller.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.avgh.bibliotaller.repository.BookRepository
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val BookRepository: BookRepository

    val allBooks: LiveData<List<Book>>

    init {
        BookRepository = BookRepository(application)
        allBooks = BookRepository.getAllBooks()
    }

    fun insert(book: Book) = viewModelScope.launch(Dispatchers.IO) { BookRepository.insert(book) }

    fun delete(book: Book) = BookRepository.deleteBook(book)

    fun update(book: Book) = BookRepository.updateBook(book)
}