package com.avgh.bibliotaller.room.dao.joinDaos

import androidx.room.*
import com.avgh.bibliotaller.room.entities.joinEntities.BookJoinTag
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface BookJoinTagDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(element: BookJoinTag)

    @Delete
    fun delete(element: BookJoinTag)

    @Update
    fun update(element: BookJoinTag)

    @Query("SELECT * FROM ${TableNameSpace.bookJoinTagTableName} WHERE bookId = :bookId")
    fun getBookJoinTag(bookId: String): List<BookJoinTag>

    @Query("SELECT * FROM ${TableNameSpace.bookJoinTagTableName}")
    fun getBookJoinTags(): List<BookJoinTag>
}