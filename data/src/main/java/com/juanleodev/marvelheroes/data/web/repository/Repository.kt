package com.juanleodev.marvelheroes.data.web.repository

import com.google.gson.Gson
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.utils.Security
import okhttp3.ResponseBody
import retrofit2.Response

open class Repository(
    val gson: Gson
) {

    protected fun getNowInMillis() = System.currentTimeMillis().toString()

    protected fun getHash(nowInMillis: String, publicKey: String, privateKey: String): String {
        val toEncrypt = nowInMillis + publicKey + privateKey
        return Security.encryptToMD5(toEncrypt)
    }

     protected fun <T> parseResponse(response: Response<T>?): Resource<T> {
         return if (response != null) {
             if (response.isSuccessful && response.body() != null) {
                 Resource.success(response.body()!!)
             } else if (response.errorBody() != null) {
                 val errorBody = parseErrorBody(response.errorBody())
                 Resource.apiError(errorBody)
             } else {
                 Resource.error()
             }
         } else {
             Resource.error()
         }
    }

    private fun parseErrorBody(errorBody: ResponseBody?): Resource.ApiError {
        // TODO
        return Resource.ApiError(1, "")
    }

}