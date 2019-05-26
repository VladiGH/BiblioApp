package com.avgh.bibliotaller.room.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.avgh.bibliotaller.utilities.TableNameSpace


@Entity(tableName = TableNameSpace.contentTableName)
@ForeignKey(
    entity = Book::class,
    parentColumns = ["ISBN"],
    childColumns = ["bookId"],
    onDelete = CASCADE
)
data class Content(
    @PrimaryKey
    val id: Int,
    val language: Int,
    val title: String,
    val resume: String,
    val bookId: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()?:"N/A",
        parcel.readString()?:"N/A",
        parcel.readString()?:"N/A"
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(language)
        parcel.writeString(title)
        parcel.writeString(resume)
        parcel.writeString(bookId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Content> {
        override fun createFromParcel(parcel: Parcel): Content {
            return Content(parcel)
        }

        override fun newArray(size: Int): Array<Content?> {
            return arrayOfNulls(size)
        }
    }
}