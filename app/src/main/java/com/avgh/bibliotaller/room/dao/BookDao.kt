package com.avgh.bibliotaller.room.dao

import androidx.room.*
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBook(book: Book)

    @Delete
    fun delete(book: Book)

    @Update
    fun update(book: Book)

    @Query("SELECT * FROM ${TableNameSpace.bookTableName} WHERE ISBN = :isbn")
    fun getBookById(isbn: String): Book

    @Query("SELECT * FROM ${TableNameSpace.bookTableName}")
    fun getBooks(): List<Book>
}