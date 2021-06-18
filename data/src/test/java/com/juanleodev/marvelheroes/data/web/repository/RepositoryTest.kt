package com.juanleodev.marvelheroes.data.web.repository

import org.junit.Assert.*
import org.junit.Test

class RepositoryTest {

    private val repository = RepositoryForTest()

    class RepositoryForTest : Repository() {

        fun getNowInMillisForTest() = super.getNowInMillis()

        fun getHashForTest(nowInMillis: String, publicKey: String, privateKey: String) = getHash(nowInMillis, publicKey, privateKey)

        fun prepareQueryForTest() = prepareQuery()
    }

    @Test
    fun getNowInMillisTest() {
        val result = repository.getNowInMillisForTest()
        assertTrue(result.isNotEmpty())
    }

    @Test
    fun getHashTest() {
        val ts = "1"
        val publicKey = "1234"
        val privateKey = "0987"
        val expected = "87082a7277b00efb963a0c83d71802d6"

        val result = repository.getHashForTest(ts, publicKey, privateKey)
        assertEquals(expected, result)
    }

    @Test
    fun prepareQueryTest() {
        val result = repository.prepareQueryForTest()
        assertNotNull(result)
        assertTrue(result.ts.isNotEmpty())
        assertTrue(result.publicKey.isNotEmpty())
        assertTrue(result.hash.isNotEmpty())
    }
}