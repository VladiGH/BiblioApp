package com.avgh.bibliotaller.room.dao.joinDaos

import androidx.room.*
import com.avgh.bibliotaller.room.entities.Tag
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface TagDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tag: Tag)

    @Update
    fun update(tag: Tag)

    @Delete
    fun delete(tag: Tag)

    @Query("SELECT * FROM ${TableNameSpace.tagTableName} WHERE id = :id")
    fun getTagById(id: Int)
}