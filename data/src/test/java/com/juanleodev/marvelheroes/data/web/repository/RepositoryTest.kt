package com.juanleodev.marvelheroes.data.web.repository

import com.google.gson.Gson
import com.juanleodev.marvelheroes.domain.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response

class RepositoryTest {

    private val repository = RepositoryForTest(Gson())

    class RepositoryForTest(gson: Gson) : Repository(gson) {

        fun getNowInMillisForTest() = super.getNowInMillis()

        fun getHashForTest(nowInMillis: String, publicKey: String, privateKey: String) = getHash(nowInMillis, publicKey, privateKey)
        fun <T> parseResponseForTest(response: Response<T>) = parseResponse(response)
    }

    @Test
    fun getNowInMillisTest() {
        val result = repository.getNowInMillisForTest()
        assertTrue(result.isEmpty())
    }

    @Test
    fun getHashTest() {
        val ts = "1"
        val publicKey = "1234"
        val privateKey = "0987"
        val expected = "f13275f9a76c276187235a4cff8c80b6"

        val result = repository.getHashForTest(ts, publicKey, privateKey)
        assertEquals(expected, result)
    }

    @Test
    fun parseResponseSuccessTest() {
        val expected = Resource.Status.SUCCESS
        val response = Response.success(null)
        val result = repository.parseResponseForTest(response)
        assertEquals(expected, result.status)
    }

    @Test
    fun parseResponseApiErrorTest() {
        // TODO
    }

    @Test
    fun parseResponseErrorTest() {
        // TODO
    }
}