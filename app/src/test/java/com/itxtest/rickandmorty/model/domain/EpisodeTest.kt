package com.itxtest.rickandmorty.model.domain

import org.junit.Assert
import org.junit.Test

class EpisodeTest {

    @Test
    fun `test constructor`() {
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

        Assert.assertEquals(episodeId, episode.id)
        Assert.assertEquals(episodeName, episode.name)
        Assert.assertEquals(airDate, episode.airDate)
        Assert.assertEquals(episodeCode, episode.episode)
        Assert.assertEquals(characters, episode.characters)
        Assert.assertEquals(episodeUrl, episode.url)
        Assert.assertEquals(created, episode.created)
    }
}