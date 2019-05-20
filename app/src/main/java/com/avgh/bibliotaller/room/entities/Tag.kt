package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(tableName = TableNameSpace.tagTableName)
data class Tag(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)