package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(
    tableName = TableNameSpace.tagTableName,
    indices = [Index("id")]
)
data class Tag(
    @PrimaryKey
    val id: Int,
    val name: String
)