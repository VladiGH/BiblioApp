package com.avgh.bibliotaller.room.dao

import androidx.room.*
import com.avgh.bibliotaller.room.entities.Book

@Dao
interface BookDao {

    @Insert
    fun insertBook(book: Book)

    @Delete
    fun deleteBook(book: Book)

    @Update
    fun updateBook(book: Book)

    @Query("SELECT * FROM book")
    fun getBooks(): Book
}