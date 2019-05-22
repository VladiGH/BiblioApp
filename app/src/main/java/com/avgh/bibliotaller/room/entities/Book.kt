package com.avgh.bibliotaller.room.entities

import android.util.SparseArray
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(tableName = TableNameSpace.bookTableName)
data class Book(
    @PrimaryKey
    val ISBN: String,
    val cover: String,
    val edition: Int,
    val favorite: Boolean
) {
    @Ignore
    val content = SparseArray<Content>(2)
    @Ignore
    val author = ArrayList<Author>()
    @Ignore
    val editorial = ArrayList<Editorial>()
    @Ignore
    val tag = ArrayList<Tag>()
}