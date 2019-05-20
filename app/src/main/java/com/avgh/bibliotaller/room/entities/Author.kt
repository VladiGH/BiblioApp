package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(tableName = TableNameSpace.autorTableName)
data class Author(
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)