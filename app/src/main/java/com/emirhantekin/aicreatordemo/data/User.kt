package com.emirhantekin.aicreatordemo.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val fie_id : Int ,
    val img : ByteArray ,
    val text : String

)
