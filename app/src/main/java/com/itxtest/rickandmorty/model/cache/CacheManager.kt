package com.itxtest.rickandmorty.model.cache

import android.content.Context
import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.domain.Episode
import com.itxtest.rickandmorty.model.domain.Location
import com.itxtest.rickandmorty.persistence.manager.LocalDBManager
import com.itxtest.rickandmorty.model.util.TimeUtils
import com.itxtest.rickandmorty.view.platform.app.ApplicationClass

class CacheManager private constructor() {

    companion object {
        private var instance: CacheManager? = null

        fun getInstance(): CacheManager {
            if (instance == null) {
                instance = CacheManager()
            }
            return instance!!
        }
    }

    private val preferences get() =
        ApplicationClass.currentActivity.getSharedPreferences(CacheConstants.PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun cache(any: Any) {
        when (any) {
            is Character -> {
                updateCacheTime(getCharacterPreferencesKey(any.id))
                LocalDBManager.insertCharacters(listOf(any))
            }
            is Location -> {
                updateCacheTime(getLocationPreferencesKey(any.id))
                LocalDBManager.insertLocations(listOf(any))
            }
            is Episode -> {
                updateCacheTime(getEpisodePreferencesKey(any.id))
                LocalDBManager.insertEpisodes(listOf(any))
            }
        }
    }

    fun getCachedCharacter(characterId: Int): Character? {
        val cacheTime = getCacheTime(getCharacterPreferencesKey(characterId))
        return if (checkIsValidCacheTime(cacheTime)) {
            LocalDBManager.getCharacter(characterId)
        } else {
            null
        }
    }

    fun getCachedLocation(locationId: Int): Location? {
        val cacheTime = getCacheTime(getLocationPreferencesKey(locationId))
        return if (checkIsValidCacheTime(cacheTime)) {
            LocalDBManager.getLocation(locationId)
        } else {
            null
        }
    }

    fun getCachedEpisode(episodeId: Int): Episode? {
        val cacheTime = getCacheTime(getEpisodePreferencesKey(episodeId))
        return if (checkIsValidCacheTime(cacheTime)) {
            LocalDBManager.getEpisode(episodeId)
        } else {
            null
        }
    }

    private fun updateCacheTime(key: String) {
        preferences.edit().putLong(key, TimeUtils.secondsFromEpoch).apply()
    }

    private fun getCacheTime(key: String): Long = preferences.getLong(key, -1)

    private fun getCharacterPreferencesKey(characterId: Int): String {
        return "${CacheConstants.CHARACTER_KEY_PREFIX}$characterId"
    }

    private fun getLocationPreferencesKey(locationId: Int): String {
        return "${CacheConstants.LOCATION_KEY_PREFIX}$locationId"
    }

    private fun getEpisodePreferencesKey(episodeId: Int): String {
        return "${CacheConstants.EPISODE_KEY_PREFIX}$episodeId"
    }

    private fun checkIsValidCacheTime(time: Long): Boolean {
        return TimeUtils.secondsFromEpoch < time + CacheConstants.CACHE_DURATION_SECONDS
    }
}
