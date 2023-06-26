package com.itxtest.rickandmorty.model.domain

import org.junit.Assert
import org.junit.Test

class LocationTest {

    @Test
    fun `test constructor`() {
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

        Assert.assertEquals(locationId, location.id)
        Assert.assertEquals(locationName, location.name)
        Assert.assertEquals(locationType, location.type)
        Assert.assertEquals(dimension, location.dimension)
        Assert.assertEquals(residents, location.residents)
        Assert.assertEquals(locationUrl, location.url)
        Assert.assertEquals(created, location.created)
    }
}
