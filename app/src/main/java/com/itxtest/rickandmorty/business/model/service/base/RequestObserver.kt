package com.itxtest.rickandmorty.business.model.service.base

import com.itxtest.rickandmorty.business.model.error.ErrorHandler

abstract class RequestObserver<T> {
    abstract fun onSuccess(response: T)
    open fun onError(throwable: Throwable?) {
        ErrorHandler.getInstance().onServiceError(throwable)
    }
}
