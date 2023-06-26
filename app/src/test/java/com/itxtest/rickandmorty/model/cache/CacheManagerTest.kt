package com.itxtest.rickandmorty.model.cache

import com.itxtest.rickandmorty.base.BaseTest
import com.itxtest.rickandmorty.model.domain.Character
import com.itxtest.rickandmorty.model.domain.Episode
import com.itxtest.rickandmorty.model.domain.Location
import com.itxtest.rickandmorty.persistence.manager.LocalDBManager
import io.mockk.justRun
import io.mockk.mockkObject
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class CacheManagerTest : BaseTest() {

    @Before
    override fun setUp() {
        super.setUp()
        mockkObject(LocalDBManager)
        justRun { LocalDBManager.insertCharacters(any()) }
        justRun { LocalDBManager.insertEpisodes(any()) }
        justRun { LocalDBManager.insertLocations(any()) }
    }

    @Test
    fun `test cache Character`() {
        val location = Location(0, "", "", "", listOf(), "", "")
        val character = Character(
            id = 1,
            name = "Rick",
            status = "Alive",
            species = "",
            type = "",
            gender = "",
            origin = location,
            lastKnownLocation = location,
            image = "",
            episode = listOf(),
            url = "",
            created = ""
        )

        CacheManager.getInstance().cache(character)

        verify(exactly = 1) { LocalDBManager.insertCharacters(listOf(character)) }
    }

    @Test
    fun `test cache Location`() {
        val location = Location(0, "", "", "", listOf(), "", "")

        CacheManager.getInstance().cache(location)

        verify(exactly = 1) { LocalDBManager.insertLocations(listOf(location)) }
    }

    @Test
    fun `test cache Episode`() {
        val episodeId = 1
        val episodeName = "Episode Name"
        val airDate = "Air date"
        val episodeCode = "Episode Code"
        val characters = listOf<String>()
        val episodeUrl = "Episode Url"
        val created = "Creation date"

        val episode = Episode(
            id = episodeId,
            name = episodeName,
            airDate = airDate,
            episode = episodeCode,
            characters = characters,
            url = episodeUrl,
            created = created
        )

        CacheManager.getInstance().cache(episode)

        verify(exactly = 1) { LocalDBManager.insertEpisodes(listOf(episode)) }
    }

    @Test
    fun `test cache unknown type`() {
        CacheManager.getInstance().cache("string")

        verify(exactly = 0) { LocalDBManager.insertCharacters(any()) }
        verify(exactly = 0) { LocalDBManager.insertLocations(any()) }
        verify(exactly = 0) { LocalDBManager.insertEpisodes(any()) }
    }
}
