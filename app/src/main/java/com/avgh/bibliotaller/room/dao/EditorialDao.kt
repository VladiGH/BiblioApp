package com.avgh.bibliotaller.room.dao

import androidx.room.*
import com.avgh.bibliotaller.room.entities.Editorial
import com.avgh.bibliotaller.utilities.TableNameSpace

@Dao
interface EditorialDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(element: Editorial)

    @Update
    fun update(element: Editorial)

    @Delete
    fun delete(element: Editorial)

    @Query("SELECT * FROM ${TableNameSpace.editorialTableName} WHERE id = :id")
    fun getEditorialById(id: Int)
}