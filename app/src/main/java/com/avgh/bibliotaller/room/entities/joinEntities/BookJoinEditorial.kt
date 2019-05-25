package com.avgh.bibliotaller.room.entities.joinEntities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.avgh.bibliotaller.room.entities.Book
import com.avgh.bibliotaller.room.entities.Editorial
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(
    tableName = TableNameSpace.bookJoinEditorial,
    primaryKeys = ["bookId", "editorialId"],
    foreignKeys = [
        ForeignKey(
            entity = Book::class,
            parentColumns = ["ISBN"],
            childColumns = ["bookId"]
        ),
        ForeignKey(
            entity = Editorial::class,
            parentColumns = ["id"],
            childColumns = ["editorialId"]
        )
    ]
)
data class BookJoinEditorial(
    val bookId: String,
    val editorialId: Int
)