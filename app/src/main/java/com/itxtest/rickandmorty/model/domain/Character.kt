package com.itxtest.rickandmorty.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.itxtest.rickandmorty.persistence.constant.LocalDBConstants

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
) {
    companion object {
        private const val ALIVE = "Alive"
        private const val DEAD = "Dead"
    }

    fun isAlive(): Boolean = status == ALIVE

    fun isDead(): Boolean = status == DEAD

    override fun equals(other: Any?): Boolean {
        return if (other is Character) other.id == id else false
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
