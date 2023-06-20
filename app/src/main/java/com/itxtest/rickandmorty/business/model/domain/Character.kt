package com.itxtest.rickandmorty.business.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.itxtest.rickandmorty.business.model.persistence.constant.LocalDBConstants

@Entity(tableName = LocalDBConstants.CHARACTERS_TABLE_NAME)
data class Character(
    @PrimaryKey @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: Location,
    @SerializedName("location")
    val lastKnownLocation: Location,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)
