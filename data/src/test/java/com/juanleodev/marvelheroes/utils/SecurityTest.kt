package com.juanleodev.marvelheroes.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class SecurityTest {

    @Test
    fun encryptToMD5Test() {
        val expected = "c4ca4238a0b923820dcc509a6f75849b"
        val result = Security.encryptToMD5("1")
        assertEquals(expected, result)
    }

}