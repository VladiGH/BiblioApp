package com.avgh.bibliotaller.test

import android.os.Parcel
import android.os.Parcelable

data class BookTest(var cover: Int) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(cover)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<BookTest> = object : Parcelable.Creator<BookTest> {
            override fun createFromParcel(source: Parcel): BookTest = BookTest(source)
            override fun newArray(size: Int): Array<BookTest?> = arrayOfNulls(size)
        }
    }
}