package com.itxtest.rickandmorty.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.domain.Episode
import com.itxtest.rickandmorty.model.domain.Location
import com.itxtest.rickandmorty.persistence.converter.Converters
import com.itxtest.rickandmorty.persistence.dao.DAOCharacter
import com.itxtest.rickandmorty.persistence.dao.DAOEpisode
import com.itxtest.rickandmorty.persistence.dao.DAOLocation

@Database(entities = [Character::class, Location::class, Episode::class], version = 1)
@TypeConverters(Converters::class)
abstract class LocalDB : RoomDatabase() {
    abstract fun getCharactersDAO(): DAOCharacter
    abstract fun getLocationsDAO(): DAOLocation
    abstract fun getEpisodesDAO(): DAOEpisode
}