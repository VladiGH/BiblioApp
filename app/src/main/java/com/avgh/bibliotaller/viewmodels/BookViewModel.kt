package com.avgh.bibliotaller.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.avgh.bibliotaller.repository.BookRepository
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.Lagunajes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val BookRepository: BookRepository

    var allBooks: LiveData<List<Book>>

    init {
        BookRepository = BookRepository(application)

        //allBooks = BookRepository.getBooksByLanguaje(Lagunajes.English)
        allBooks = BookRepository.getAllBooks()


    }

    fun insert(book: Book) = viewModelScope.launch(Dispatchers.IO) { BookRepository.insert(book) }

    fun getBooks() = viewModelScope.launch(Dispatchers.IO) {
        BookRepository.getAllBooks()
    }

    fun delete(book: Book) = BookRepository.deleteBook(book)

    fun update(book: Book) = BookRepository.updateBook(book)
}