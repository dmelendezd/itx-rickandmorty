package com.itxtest.rickandmorty.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itxtest.rickandmorty.model.domain.Episode
import com.itxtest.rickandmorty.persistence.constant.LocalDBConstants

@Dao
interface DAOEpisode {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(episodes: List<Episode>)

    @Query("SELECT * FROM ${LocalDBConstants.EPISODES_TABLE_NAME} WHERE id=:episodeId")
    fun select(episodeId: Int): Episode?
}
