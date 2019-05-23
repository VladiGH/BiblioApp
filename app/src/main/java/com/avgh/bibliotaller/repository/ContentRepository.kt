package com.avgh.bibliotaller.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.avgh.bibliotaller.room.dao.ContentDao
import com.avgh.bibliotaller.room.entities.Content

class ContentRepository(private val contentDao: ContentDao) {

    @WorkerThread
    fun insert(element: Content){
        contentDao.insert(element)
    }

    fun delete(element: Content){
        contentDao.delete(element)
    }

    fun update(element: Content){
        contentDao.update(element)
    }

    fun getContents(ISBN: String): List<Content> = contentDao.getContents(ISBN)

    fun getContent(ISBN: String, language: Int): Content = contentDao.getContent(ISBN, language)
}