package com.avgh.bibliotaller.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.avgh.bibliotaller.room.entities.Author
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface AuthorDao {

    @Insert
    fun insert(author: Author)

    @Update
    fun update(author: Author)

    @Delete
    fun delete(author: Author)

    @Query("SELECT * FROM ${TableNameSpace.authorTableName} WHERE id = :authorId")
    fun getAuthor(authorId: Int): Author

    @Query("SELECT * FROM ${TableNameSpace.authorTableName}")
    fun getAuthors(): List<Author>
}