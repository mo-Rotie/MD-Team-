package com.dicoding.morotie.model

import android.os.Parcel
import android.os.Parcelable

data class  MoldItem(
    val id: Int,
    val Nama: String,
    val jenis: String,
    val Deskripsi: String,
    val Gambar: String,
    val Spesies: String,
    val Gejala_keracunan: String,
    val Pengobatan: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(Nama)
        parcel.writeString(jenis)
        parcel.writeString(Deskripsi)
        parcel.writeString(Gambar)
        parcel.writeString(Spesies)
        parcel.writeString(Gejala_keracunan)
        parcel.writeString(Pengobatan)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoldItem> {
        override fun createFromParcel(parcel: Parcel): MoldItem {
            return MoldItem(parcel)
        }

        override fun newArray(size: Int): Array<MoldItem?> {
            return arrayOfNulls(size)
        }
    }
}
