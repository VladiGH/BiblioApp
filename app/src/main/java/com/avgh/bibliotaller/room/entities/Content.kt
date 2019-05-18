package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content")
data class Content(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val resume: String,
    val bookId: String
)