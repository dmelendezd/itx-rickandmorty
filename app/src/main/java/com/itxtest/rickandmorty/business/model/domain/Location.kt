package com.itxtest.rickandmorty.business.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.itxtest.rickandmorty.business.model.persistence.constant.LocalDBConstants

@Entity(tableName = LocalDBConstants.LOCATIONS_TABLE_NAME)
data class Location(
    @PrimaryKey @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)
