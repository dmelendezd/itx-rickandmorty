package com.itxtest.rickandmorty.business.model.service.response

import com.google.gson.annotations.SerializedName

data class QueryResponse<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<T>
)
