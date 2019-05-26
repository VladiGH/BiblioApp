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

    private val bookRepository: BookRepository = BookRepository(application)
    lateinit var books: LiveData<List<Book>>

    fun insert(book: Book) = viewModelScope.launch(Dispatchers.IO) { bookRepository.insert(book) }

    fun delete(book: Book) = bookRepository.deleteBook(book)

    fun update(book: Book) = bookRepository.updateBook(book)

    fun getBooksInLanguaje(language: Int) = viewModelScope.launch(Dispatchers.IO) {
        books = MutableLiveData(bookRepository.getFullBooks(language))
    }

    fun getBooks(callback: (data: LiveData<List<Book>>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            books = MutableLiveData(bookRepository.getFullBooks(Languages.ENGLISH))
            callback(books)
        }
    }
}