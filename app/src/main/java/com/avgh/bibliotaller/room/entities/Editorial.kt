package com.avgh.bibliotaller.room.entities

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()?:"N/A",
        parcel.readString()?:"N/A",
        parcel.readString()?:"N/A"
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(year)
        parcel.writeString(city)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Editorial> {
        override fun createFromParcel(parcel: Parcel): Editorial {
            return Editorial(parcel)
        }

        override fun newArray(size: Int): Array<Editorial?> {
            return arrayOfNulls(size)
        }
    }
}