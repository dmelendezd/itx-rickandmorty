package com.itxtest.rickandmorty.model.service.base

import com.itxtest.rickandmorty.model.cache.CacheManager
import com.itxtest.rickandmorty.model.service.constant.NetworkConstants
import com.itxtest.rickandmorty.model.service.response.QueryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseService<T> {

    protected var resource = ""
    protected val requestUrl get() = NetworkConstants.RICK_MORTY_API_BASE_URL + resource
    private val observers = arrayListOf<RequestObserver<T>>()
    protected val cacheManager get() = CacheManager.getInstance()

    abstract fun start()

    protected fun onServiceSuccess(response: T, cacheResponse: Boolean = false) {
        observers.forEach { it.onSuccess(response) }
        if (cacheResponse) {
            cacheResponse(response)
        }
    }

    protected fun onServiceError(t: Throwable?) {
        observers.forEach { it.onError(t) }
    }

    fun subscribe(observer: RequestObserver<T>): BaseService<T> {
        observers.add(observer)
        return this
    }

    protected fun getCallback(): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    response.body()?.let { onServiceSuccess(it, true) }
                } else {
                    onServiceError(null)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                onServiceError(t)
            }
        }
    }

    protected fun addResourceParameter(param: String) {
        resource = "$resource/$param"
    }

    protected fun addUrlParameter(key: String, value: String) {
        if (resource.contains("?")) {
            resource = "$resource&$key=$value"
        } else {
            resource = "$resource?$key=$value"
        }
    }

    private fun cacheResponse(response: T) {
        val resultsToCach =
            when (response) {
                is List<*> -> response
                is QueryResponse<*> -> response.results
                else -> null
            }
        resultsToCach?.forEach {
            if (it != null) {
                cacheManager.cache(it)
            }
        }
    }
}
