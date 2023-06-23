package com.itxtest.rickandmorty.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itxtest.rickandmorty.model.domain.Location
import com.itxtest.rickandmorty.persistence.constant.LocalDBConstants

@Dao
interface DAOLocation {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(locations: List<Location>)

    @Query("SELECT * FROM ${LocalDBConstants.LOCATIONS_TABLE_NAME} WHERE id=:locationId")
    fun select(locationId: Int): Location?
}
