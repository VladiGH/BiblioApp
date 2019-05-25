package com.avgh.bibliotaller.room.dao.joinDaos

import androidx.room.*
import com.avgh.bibliotaller.room.entities.joinEntities.BookJoinAuthor
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface BookJoinAuthorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(element: BookJoinAuthor)

    @Delete
    fun delete(element: BookJoinAuthor)

    @Update
    fun update(element: BookJoinAuthor)


    @Query("SELECT * FROM ${TableNameSpace.bookJoinAuthor} WHERE bookId = :bookId")
    fun getBookJoinAuthor(bookId: String): List<BookJoinAuthor>
}