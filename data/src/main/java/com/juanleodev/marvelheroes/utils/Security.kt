package com.juanleodev.marvelheroes.utils

import java.math.BigInteger
import java.security.MessageDigest

class Security {

    companion object {

        fun encryptToMD5(toEncrypt: String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(toEncrypt.toByteArray())).toString(16).padStart(32, '0')
        }

    }

}