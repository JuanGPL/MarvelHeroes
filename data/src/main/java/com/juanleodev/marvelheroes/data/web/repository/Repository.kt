package com.juanleodev.marvelheroes.data.web.repository

import com.juanleodev.marvelheroes.data.BuildConfig
import com.juanleodev.marvelheroes.utils.Security

open class Repository {

    protected fun getNowInMillis() = System.currentTimeMillis().toString()

    protected fun getHash(nowInMillis: String, publicKey: String, privateKey: String): String {
        val toEncrypt = nowInMillis + privateKey + publicKey
        return Security.encryptToMD5(toEncrypt)
    }

    protected fun prepareQuery(): Query {
        val ts = getNowInMillis()
        val hash = getHash(ts, BuildConfig.PUBLIC_API_KEY, BuildConfig.PRIVATE_API_KEY)

        return Query(ts, BuildConfig.PUBLIC_API_KEY, hash)
    }

    data class Query(val ts: String, val publicKey: String, val hash: String)

    protected fun nullResponseBodyException() = Exception("Null Response.body() exception")

}