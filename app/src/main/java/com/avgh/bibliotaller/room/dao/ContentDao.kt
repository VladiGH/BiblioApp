package com.avgh.bibliotaller.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.avgh.bibliotaller.room.entities.Content
import com.avgh.bibliotaller.utilities.TableNameSpace


@Dao
interface ContentDao{

    @Insert
    fun inser(element: Content)

    @Delete
    fun delet(element: Content)

    @Update
    fun updat(element: Content)

    @Query("SELECT * FROM ${TableNameSpace.contentTableName}")
    fun getContents(): LiveData<List<Content>>

    @Query("SELECT * FROM ${TableNameSpace.contentTableName} WHERE bookId =:ISBN")
    fun getContent(ISBN : String): LiveData<Content>

}