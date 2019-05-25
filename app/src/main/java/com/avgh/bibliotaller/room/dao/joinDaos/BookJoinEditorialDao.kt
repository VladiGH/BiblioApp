package com.avgh.bibliotaller.room.dao.joinDaos

import androidx.room.*
import com.avgh.bibliotaller.room.entities.Editorial
import com.avgh.bibliotaller.room.entities.joinEntities.BookJoinEditorial
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface BookJoinEditorialDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(element: BookJoinEditorial)

    @Update
    fun update(element: BookJoinEditorial)

    @Delete
    fun delete(element: BookJoinEditorial)

    @Query("SELECT * FROM ${TableNameSpace.bookJoinEditorial} WHERE editorialId = :id")
    fun getEditorialBooks(id: Int): List<BookJoinEditorial>

    @Query("SELECT * FROM ${TableNameSpace.bookJoinEditorial} WHERE bookId = :bookId")
    fun getEdiorialbyBook(bookId: String): List<BookJoinEditorial>
}