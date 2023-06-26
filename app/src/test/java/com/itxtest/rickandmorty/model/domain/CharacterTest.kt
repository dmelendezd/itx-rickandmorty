package com.itxtest.rickandmorty.model.domain

import org.junit.Assert
import org.junit.Test

class CharacterTest {

    @Test
    fun `test isAlive returns true`() {
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
        Assert.assertTrue(character.isAlive())
    }

    @Test
    fun `test isAlive returns false`() {
        val location = Location(0, "", "", "", listOf(), "", "")
        val character = Character(
            id = 1,
            name = "Rick",
            status = "unknown",
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
        Assert.assertFalse(character.isAlive())
    }

    @Test
    fun `test isDead returns true`() {
        val location = Location(0, "", "", "", listOf(), "", "")
        val character = Character(
            id = 1,
            name = "Rick",
            status = "Dead",
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
        Assert.assertTrue(character.isDead())
    }

    @Test
    fun `test isDead returns false`() {
        val location = Location(0, "", "", "", listOf(), "", "")
        val character = Character(
            id = 1,
            name = "Rick",
            status = "unknown",
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
        Assert.assertFalse(character.isDead())
    }

    @Test
    fun `test equals returns true`() {
        val ch1 = getCharacter(1)
        val ch2 = getCharacter(1)

        val result = ch1.equals(ch2)

        Assert.assertTrue(result)
    }

    @Test
    fun `test equals returns false`() {
        val ch1 = getCharacter(1)
        val ch2 = getCharacter(2)

        val result = ch1.equals(ch2)

        Assert.assertFalse(result)
    }

    @Test
    fun `test hashcode`() {
        val id = 10
        val character = getCharacter(id)

        val result = character.hashCode()

        Assert.assertEquals(id.hashCode(), result)
    }

    private fun getCharacter(id: Int): Character {
        val location = Location(0, "", "", "", listOf(), "", "")
        return Character(
            id = id,
            name = "",
            status = "",
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
    }
}