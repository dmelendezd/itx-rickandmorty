package com.itxtest.rickandmorty.business.model.persistence.manager

import androidx.room.Room
import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.business.model.domain.Episode
import com.itxtest.rickandmorty.business.model.domain.Location
import com.itxtest.rickandmorty.business.model.persistence.constant.LocalDBConstants
import com.itxtest.rickandmorty.business.model.persistence.database.LocalDB
import com.itxtest.rickandmorty.platform.app.ApplicationClass

object LocalDBManager {

    private val database: LocalDB by lazy {
        Room.databaseBuilder(
            ApplicationClass.currentActivity, LocalDB::class.java, LocalDBConstants.DATABASE_NAME
        ).allowMainThreadQueries().build()
    }

    fun getCharacter(id: Int): Character? {
        return database.getCharactersDAO().select(id)
    }

    fun getLocation(id: Int): Location? {
        return database.getLocationsDAO().select(id)
    }

    fun getEpisode(id: Int): Episode? {
        return database.getEpisodesDAO().select(id)
    }

    fun insertCharacters(characters: List<Character>) {
        database.getCharactersDAO().insert(characters)
    }

    fun insertLocations(locations: List<Location>) {
        database.getLocationsDAO().insert(locations)
    }

    fun insertEpisodes(episodes: List<Episode>) {
        database.getEpisodesDAO().insert(episodes)
    }
}