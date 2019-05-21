package com.avgh.bibliotaller.repository

import androidx.annotation.WorkerThread
import androidx.core.widget.AutoScrollHelper
import androidx.lifecycle.LiveData
import com.avgh.bibliotaller.room.entities.Author

class AuthorDao(private val authorDao: AuthorDao) {

    @WorkerThread
    fun insert(author: Author){
        authorDao.insert(author)
    }

    fun update(author: Author){
        authorDao.update(author)
    }

    fun delete(author: Author){
        authorDao.delete(author)
    }

    fun getAuthor(authorId: Int): LiveData<Author> = authorDao.getAuthor(authorId)

    fun getAuthors(): LiveData<List<Author>> = authorDao.getAuthors()


}