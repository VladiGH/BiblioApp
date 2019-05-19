package com.avgh.bibliotaller.room.dao.joinDaos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.room.entities.Tag
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface BookJoinTagDao {

    @Insert
    fun insert(book: Book, tag: Tag)

    @Delete
    fun delete(book: Book)

    @Update
    fun update(book: Book)

    @Query("SELECT * FROM ${TableNameSpace.bookTableName}")
    fun getBookJoinTagDao(): LiveData<Book>

    @Query("SELECT * FROM ${TableNameSpace.bookTableName}")
    fun getBookJoinTagDaos(): LiveData<List<Book>>
}