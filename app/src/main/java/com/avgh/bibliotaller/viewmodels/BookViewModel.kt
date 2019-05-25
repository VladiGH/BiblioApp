package com.avgh.bibliotaller.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.avgh.bibliotaller.repository.BookRepository
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.Languages
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            books = MutableLiveData(bookRepository.getFullBooks(Languages.ENGLISH))
        }
    }

    private val bookRepository: BookRepository = BookRepository(application)

    var books: LiveData<List<Book>>? = null

    fun insert(book: Book) = viewModelScope.launch(Dispatchers.IO) { bookRepository.insert(book) }

    fun delete(book: Book) = bookRepository.deleteBook(book)

    fun update(book: Book) = bookRepository.updateBook(book)

    fun getBooksInLanguaje(language: Int) = viewModelScope.launch(Dispatchers.IO) {
        bookRepository.getFullBooks(language)
    }
}