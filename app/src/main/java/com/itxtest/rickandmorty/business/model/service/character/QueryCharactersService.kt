package com.itxtest.rickandmorty.business.model.service.character

import com.itxtest.rickandmorty.business.model.service.base.BaseService
import com.itxtest.rickandmorty.business.model.service.base.RetrofitProvider
import com.itxtest.rickandmorty.business.model.service.constant.NetworkConstants
import com.itxtest.rickandmorty.business.model.service.response.QueryResponse
import com.itxtest.rickandmorty.business.model.domain.Character

class QueryCharactersService(queryParams: Map<String, String>) : BaseService<QueryResponse<Character>>() {

    init {
        resource = NetworkConstants.CHARACTERS_RESOURCE
        queryParams.forEach { (key, value) -> addUrlParameter(key, value) }
    }

    override fun start() {
        RetrofitProvider.apiService.queryCharacters(requestUrl).enqueue(getCallback())
    }
}
