package com.avgh.bibliotaller.room.entities.joinEntities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.avgh.bibliotaller.room.entities.Author
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(
    tableName = TableNameSpace.bookJoinAuthor,
    primaryKeys = ["bookId", "id"],
    foreignKeys = [
        ForeignKey(
            entity = Book::class,
            parentColumns = ["ISBN"],
            childColumns = ["bookId"]
        ),
        ForeignKey(
            entity = Author::class,
            parentColumns = ["id"],
            childColumns = ["id"]
        )
    ]
)
data class BookJoinAuthor(
    val bookId: String,
    val id: Int
)