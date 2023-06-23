package com.itxtest.rickandmorty.persistence.converter

import androidx.room.TypeConverter
import com.itxtest.rickandmorty.model.domain.Location

class Converters {

    companion object {
        private const val SEPARATOR = ";"
    }

    @TypeConverter
    fun toString(location: Location): String {
        return "${location.name}$SEPARATOR${location.url}"
    }

    @TypeConverter
    fun toLocation(string: String): Location {
        return Location(
            id = -1,
            name = string.split(SEPARATOR)[0],
            type = "",
            dimension = "",
            residents = listOf(),
            url = string.split(SEPARATOR)[1],
            created = ""
        )
    }

    @TypeConverter
    fun toString(list: List<String>): String {
        var string = ""
        list.forEach {
            string = if (string.isEmpty()) it else "$string$SEPARATOR$it"
        }
        return string
    }

    @TypeConverter
    fun toStringList(string: String): List<String> {
        return if (string.contains(SEPARATOR)) string.split(SEPARATOR) else listOf(string)
    }
}