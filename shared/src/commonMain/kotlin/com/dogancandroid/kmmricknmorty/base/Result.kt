package com.dogancandroid.kmmricknmorty.base

sealed class ApiResult<T>(val data: T, val error: Throwable? = null) {
    class Success<T>(data: T) : ApiResult<T>(data)
    class Error<T>(error: Throwable? = null) : ApiResult<T>(null as T, error)
    class Loading<T>() : ApiResult<T>(null as T)
}

fun <T, R> ApiResult<T>.map(transform: (T) -> R): ApiResult<R> {
    return when (this) {
        is ApiResult.Success -> {
            ApiResult.Success(transform(data))
        }
        is ApiResult.Loading -> {
            ApiResult.Loading()
        }
        is ApiResult.Error -> {
            ApiResult.Error(error)
        }
    }
}
