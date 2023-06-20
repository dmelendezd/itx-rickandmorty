package com.itxtest.rickandmorty.business.model.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.business.model.persistence.constant.LocalDBConstants

@Dao
interface DAOCharacter {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characters: List<Character>)

    @Query("SELECT * FROM ${LocalDBConstants.CHARACTERS_TABLE_NAME} WHERE id=:characterId")
    fun select(characterId: Int): Character?
}