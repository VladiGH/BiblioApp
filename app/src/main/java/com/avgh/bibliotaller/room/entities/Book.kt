package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey
    val ISBN: String,
    val cover: String,
    val edition: Int
)