package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(
    tableName = TableNameSpace.autorTableName,
    indices = [androidx.room.Index("id")]
)
data class Author(
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)