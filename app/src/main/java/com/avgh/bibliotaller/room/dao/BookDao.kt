package com.avgh.bibliotaller.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface BookDao {

    @Insert
    fun insertBook(book: Book)

    @Delete
    fun delete(book: Book)

    @Update
    fun update(book: Book)

    @Query("SELECT * FROM ${TableNameSpace.bookTableName}")
    fun getBook(): LiveData<Book>

    @Query("SELECT * FROM ${TableNameSpace.bookTableName}")
    fun getBooks(): LiveData<List<Book>>
}