package com.juanleodev.marvelheroes.domain


class Resource<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val apiError: ApiError? = null
) {

    companion object {
        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING)
        }

        fun <T> error(): Resource<T> {
            return Resource(Status.ERROR)
        }

        fun <T> apiError(apiError: ApiError?): Resource<T> {
            return Resource(Status.API_ERROR, apiError = apiError)
        }

        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }
    }

    enum class Status {
        LOADING,
        ERROR,
        API_ERROR,
        SUCCESS
    }

    class ApiError(
        private val code: Int,
        private val status: String
    )
}