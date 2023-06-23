package com.itxtest.rickandmorty.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.itxtest.rickandmorty.persistence.constant.LocalDBConstants

@Entity(tableName = LocalDBConstants.EPISODES_TABLE_NAME)
data class Episode(
    @PrimaryKey @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)
