package com.avgh.bibliotaller.room.entities.joinEntities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.room.entities.Tag
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(tableName = TableNameSpace.bookJoinTagTableName,
    primaryKeys = ["bookId", "tagId"],
    foreignKeys = [
        ForeignKey(entity = Book::class,
            parentColumns = ["ISBN"],
            childColumns = ["bookId"]),
        ForeignKey(entity = Tag::class,
            parentColumns = ["id"],
            childColumns = ["tagId"])
    ])
data class BookJoinTag(
    val bookId: String,
    val tagId: Int
)