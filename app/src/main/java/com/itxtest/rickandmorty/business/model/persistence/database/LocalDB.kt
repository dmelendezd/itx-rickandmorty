package com.itxtest.rickandmorty.business.model.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.business.model.domain.Episode
import com.itxtest.rickandmorty.business.model.domain.Location
import com.itxtest.rickandmorty.business.model.persistence.converter.Converters
import com.itxtest.rickandmorty.business.model.persistence.dao.DAOCharacter
import com.itxtest.rickandmorty.business.model.persistence.dao.DAOEpisode
import com.itxtest.rickandmorty.business.model.persistence.dao.DAOLocation

@Database(entities = [Character::class, Location::class, Episode::class], version = 1)
@TypeConverters(Converters::class)
abstract class LocalDB : RoomDatabase() {
    abstract fun getCharactersDAO(): DAOCharacter
    abstract fun getLocationsDAO(): DAOLocation
    abstract fun getEpisodesDAO(): DAOEpisode
}