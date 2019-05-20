package com.avgh.bibliotaller.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.avgh.bibliotaller.repository.BibliotecaRepository
import com.avgh.bibliotaller.room.LibraryDatabase
import com.avgh.bibliotaller.room.entities.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BibliotecaRepository

    val allBooks : LiveData<List<Book>>

    init{
        val booksDao = LibraryDatabase.getDatabase(application).bookDao()
        repository = BibliotecaRepository(booksDao)
        allBooks = repository.getAllBooks()
    }

    fun insert(book:Book) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(book)
    }
}