package com.itxtest.rickandmorty.model.service.base

import com.itxtest.rickandmorty.model.error.ErrorHandler

abstract class RequestObserver<T> {
    abstract fun onSuccess(response: T)
    open fun onError(throwable: Throwable?) {
        ErrorHandler.getInstance().onServiceError(throwable)
    }
}
