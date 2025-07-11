package com.works.services

import com.google.crypto.tink.subtle.AesGcmJce
import com.google.crypto.tink.subtle.Base64
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TinkEncDec {

    @Value("\${tink.key128Bit}")
    private val key128Bit: String? = null

    @Value("\${tink.extraKey}")
    private val extraKey: String? = null


    fun encrypt(plainText: String): String {
        var cipherText = ""
        try {
            val aesGcmJce = AesGcmJce(key128Bit!!.toByteArray())
            val byteEncrypt = aesGcmJce.encrypt(plainText.toByteArray(), extraKey!!.toByteArray())
            cipherText = String(byteEncrypt, charset("ISO-8859-1"))
        } catch (e: Exception) {
            System.err.println("Encrypt Error :" + e)
        }
        cipherText = Base64.encode(cipherText.toByteArray())
        return cipherText
    }

    fun decrypt(cipherText: String): String {
        var cipherText = cipherText
        var planText = ""
        try {
            cipherText = String(Base64.decode(cipherText))
            val convertEncode = cipherText.toByteArray(charset("ISO-8859-1"))
            val aesGcmJce = AesGcmJce(key128Bit!!.toByteArray())
            val descBytes = aesGcmJce.decrypt(convertEncode, extraKey!!.toByteArray())
            planText = String(descBytes)
        } catch (e: Exception) {
            System.err.println("decrypt Error : " + e)
        }
        return planText
    }
}