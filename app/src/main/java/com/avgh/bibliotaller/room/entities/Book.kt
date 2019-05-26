package com.avgh.bibliotaller.room.entities

import android.os.Parcel
import android.os.Parcelable
import android.util.SparseArray
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace

@Entity(tableName = TableNameSpace.bookTableName)
data class Book(
    @PrimaryKey
    val ISBN: String,
    val cover: String,
    val edition: Int,
    val favorite: Boolean
) : Parcelable {
    @Ignore
    val content = SparseArray<Content>(2)

    @Ignore
    val author = ArrayList<Author>()

    @Ignore
    val editorial = ArrayList<Editorial>()

    @Ignore
    val tag = ArrayList<Tag>()

    constructor(source: Parcel) : this(
        source.readString()?:"N/A",
        source.readString()?:"",
        source.readInt(),
        1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(ISBN)
        writeString(cover)
        writeInt(edition)
        writeInt((if (favorite) 1 else 0))
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Book> = object : Parcelable.Creator<Book> {
            override fun createFromParcel(source: Parcel): Book = Book(source)
            override fun newArray(size: Int): Array<Book?> = arrayOfNulls(size)
        }
    }
}