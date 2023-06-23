package com.itxtest.rickandmorty.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.persistence.constant.LocalDBConstants

@Dao
interface DAOCharacter {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characters: List<Character>)

    @Query("SELECT * FROM ${LocalDBConstants.CHARACTERS_TABLE_NAME} WHERE id=:characterId")
    fun select(characterId: Int): Character?
}