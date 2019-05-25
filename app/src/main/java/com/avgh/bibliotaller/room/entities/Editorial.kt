package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(tableName = TableNameSpace.editorialTableName)
data class Editorial(
    @PrimaryKey
    val id: Int,
    val name: String,
    val year: String,
    val city: String
)