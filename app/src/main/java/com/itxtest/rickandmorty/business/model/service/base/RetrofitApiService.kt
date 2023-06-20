package com.itxtest.rickandmorty.business.model.service.base

import com.itxtest.rickandmorty.business.model.service.response.QueryResponse
import com.itxtest.rickandmorty.business.model.domain.Character
import com.itxtest.rickandmorty.business.model.domain.Episode
import com.itxtest.rickandmorty.business.model.domain.Location
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitApiService {

    @GET
    fun getCharacters(@Url url: String): Call<List<Character>>
    @GET
    fun queryCharacters(@Url url: String): Call<QueryResponse<Character>>

    @GET
    fun getLocations(@Url url: String): Call<List<Location>>
    @GET
    fun queryLocations(@Url url: String): Call<QueryResponse<Location>>

    @GET
    fun getEpisodes(@Url url: String): Call<List<Episode>>
    @GET
    fun queryEpisodes(@Url url: String): Call<QueryResponse<Episode>>
}
