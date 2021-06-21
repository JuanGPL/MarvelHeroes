package com.juanleodev.marvelheroes.utils

import com.juanleodev.marvelheroes.domain.error.ErrorEntity
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class ErrorHandlerTest {

    @Test
    fun invoke1Test_IOException() {
        val errorHandler = ErrorHandler()
        val result = errorHandler(IOException())
        assertEquals(ErrorEntity.Network, result)
    }

    @Test
    fun invoke1Test_HttpException_404() {
        val errorHandler = ErrorHandler()
        val error = Response.error<Any>(404, ResponseBody.create(null, ""))
        val result = errorHandler(HttpException(error))
        assertEquals(ErrorEntity.NotFound, result)
    }

    @Test
    fun invoke1Test_HttpException_503() {
        val errorHandler = ErrorHandler()
        val error = Response.error<Any>(503, ResponseBody.create(null, ""))
        val result = errorHandler(HttpException(error))
        assertEquals(ErrorEntity.ServiceUnavailable, result)
    }

    @Test
    fun invoke1Test_HttpException_AnyOther() {
        val errorHandler = ErrorHandler()
        val error = Response.error<Any>(500, ResponseBody.create(null, ""))
        val result = errorHandler(HttpException(error))
        assertEquals(ErrorEntity.Unknown, result)
    }

    @Test
    fun invoke1Test_Exception() {
        val errorHandler = ErrorHandler()
        val result = errorHandler(Exception(""))
        assertEquals(ErrorEntity.Unknown, result)
    }



    @Test
    fun invoke2Test_HttpException_404() {
        val errorHandler = ErrorHandler()
        val result = errorHandler(404, null)
        assertEquals(ErrorEntity.NotFound, result)
    }

    @Test
    fun invoke2Test_HttpException_503() {
        val errorHandler = ErrorHandler()
        val result = errorHandler(503, null)
        assertEquals(ErrorEntity.ServiceUnavailable, result)
    }

    @Test
    fun invoke2Test_HttpException_AnyOther() {
        val errorHandler = ErrorHandler()
        val result = errorHandler(500, null)
        assertEquals(ErrorEntity.Unknown, result)
    }

    @Test
    fun invoke2Test_WithErrorBody() {
        val errorHandler = ErrorHandler()
        val result = errorHandler(500,
            ResponseBody.create(null, "{\"status\": \"Error message\"}"))
        assertEquals("Error message", result.message)
    }
}