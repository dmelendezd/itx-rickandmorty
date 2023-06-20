package com.itxtest.rickandmorty.business.model.service.location

import com.itxtest.rickandmorty.business.model.service.base.BaseService
import com.itxtest.rickandmorty.business.model.service.base.RetrofitProvider
import com.itxtest.rickandmorty.business.model.service.constant.NetworkConstants
import com.itxtest.rickandmorty.business.model.service.response.QueryResponse
import com.itxtest.rickandmorty.business.model.domain.Location

class QueryLocationsService(queryParams: Map<String, String>) : BaseService<QueryResponse<Location>>() {

    init {
        resource = NetworkConstants.LOCATION_RESOURCE
        queryParams.forEach { (key, value) -> addUrlParameter(key, value) }
    }

    override fun start() {
        RetrofitProvider.apiService.queryLocations(requestUrl).enqueue(getCallback())
    }
}