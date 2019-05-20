package com.avgh.bibliotaller.room.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(tableName = TableNameSpace.bookTableName)
data class Book(
    @PrimaryKey
    val ISBN: String,
    val cover: String,
    val edition: Int
) {
    @Ignore
    var content: HashMap<Int, Content>? = null
}