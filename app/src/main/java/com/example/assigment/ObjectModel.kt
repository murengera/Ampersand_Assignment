package com.example.myapp.model

import android.os.Parcel
import android.os.Parcelable

data class ObjectModel(
    val id: String,
    val name: String,
    val data: ObjectData? // Make sure this is nullable to handle cases where `data` might be `null`
) : Parcelable {

    data class ObjectData(
        val price: Double,
        val color: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readDouble(),
            parcel.readString() ?: ""
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeDouble(price)
            parcel.writeString(color)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<ObjectData> {
            override fun createFromParcel(parcel: Parcel): ObjectData {
                return ObjectData(parcel)
            }

            override fun newArray(size: Int): Array<ObjectData?> {
                return arrayOfNulls(size)
            }
        }
    }

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(ObjectData::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeParcelable(data, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ObjectModel> {
        override fun createFromParcel(parcel: Parcel): ObjectModel {
            return ObjectModel(parcel)
        }

        override fun newArray(size: Int): Array<ObjectModel?> {
            return arrayOfNulls(size)
        }
    }
}
