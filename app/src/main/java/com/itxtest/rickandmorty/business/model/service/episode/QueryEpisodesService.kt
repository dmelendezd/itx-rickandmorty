package com.itxtest.rickandmorty.business.model.service.episode

import com.itxtest.rickandmorty.business.model.service.base.BaseService
import com.itxtest.rickandmorty.business.model.service.base.RetrofitProvider
import com.itxtest.rickandmorty.business.model.service.constant.NetworkConstants
import com.itxtest.rickandmorty.business.model.service.response.QueryResponse
import com.itxtest.rickandmorty.business.model.domain.Episode

class QueryEpisodesService(queryParams: Map<String, String>) : BaseService<QueryResponse<Episode>>() {

    init {
        resource = NetworkConstants.EPISODE_RESOURCE
        queryParams.forEach { (key, value) -> addUrlParameter(key, value) }
    }

    override fun start() {
        RetrofitProvider.apiService.queryEpisodes(requestUrl).enqueue(getCallback())
    }
}
