package com.cyber.quoteapp.model.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "quotes")
data class Quote(
    @PrimaryKey(autoGenerate = true) var newId: Long? = null,
    val author: String,
    val en: String,
    @SerializedName("_id") var id: String
)
