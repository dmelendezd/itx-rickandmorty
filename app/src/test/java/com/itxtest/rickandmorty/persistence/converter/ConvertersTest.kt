package com.itxtest.rickandmorty.persistence.converter

import com.itxtest.rickandmorty.model.domain.Location
import org.junit.Assert
import org.junit.Test

class ConvertersTest {

    @Test
    fun `test toString location`() {
        val locationId = 1
        val locationName = "Location Name"
        val locationType = "type"
        val dimension = "Dimension"
        val residents = listOf<String>()
        val locationUrl = "Location Url"
        val created = "Creation date"

        val location = Location(
            id = locationId,
            name = locationName,
            type = locationType,
            dimension = dimension,
            residents = residents,
            url = locationUrl,
            created = created
        )

        val result = Converters().toString(location)

        Assert.assertEquals("$locationName;$locationUrl", result)
    }

    @Test
    fun `test toLocation`() {
        val locationName = "Name"
        val locationUrl = "https://location.url"

        val location = Converters().toLocation("$locationName;$locationUrl")

        Assert.assertEquals(locationName, location.name)
        Assert.assertEquals(locationUrl, location.url)
    }

    @Test
    fun `test toString list strings`() {
        val list = listOf("s1", "s2", "s3")

        val result = Converters().toString(list)

        Assert.assertEquals("s1;s2;s3", result)
    }

    @Test
    fun `test toStringList`() {
        val result = Converters().toStringList("s1;s2;s3")

        Assert.assertEquals(3, result.size)
        Assert.assertEquals("s1", result[0])
        Assert.assertEquals("s2", result[1])
        Assert.assertEquals("s3", result[2])
    }
}
