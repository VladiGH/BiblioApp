package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace


@Entity(tableName = TableNameSpace.contentTableName)
@ForeignKey(entity = Book::class,
    parentColumns = ["ISBN"],
    childColumns = ["bookId"],
    onDelete = CASCADE)
data class Content(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val language: Int,
    val title: String,
    val resume: String,
    val bookId: String
)