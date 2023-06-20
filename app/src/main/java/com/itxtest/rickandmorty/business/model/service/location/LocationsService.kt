package com.itxtest.rickandmorty.business.model.service.location

import com.itxtest.rickandmorty.business.model.service.base.BaseService
import com.itxtest.rickandmorty.business.model.service.base.RetrofitProvider
import com.itxtest.rickandmorty.business.model.service.constant.NetworkConstants
import com.itxtest.rickandmorty.business.model.domain.Location

class LocationsService(private val ids: List<Int>) : BaseService<List<Location>>() {

    private val uncachedLocationsIds = arrayListOf<Int>()

    init {
        resource = NetworkConstants.LOCATION_RESOURCE
    }

    override fun start() {
        val cachedLocations = getCachedLocations()
        if (cachedLocations.isNotEmpty()) {
            onServiceSuccess(cachedLocations)
        }
        if (uncachedLocationsIds.isNotEmpty()) {
            addResourceParameter(uncachedLocationsIds.toString())
            RetrofitProvider.apiService.getLocations(requestUrl).enqueue(getCallback())
        }
    }

    private fun getCachedLocations(): List<Location> {
        val validCachedLocations = arrayListOf<Location>()
        ids.forEach { locationId ->
            val location = cacheManager.getCachedLocation(locationId)
            if (location != null) {
                validCachedLocations.add(location)
            } else {
                uncachedLocationsIds.add(locationId)
            }
        }
        return validCachedLocations
    }
}