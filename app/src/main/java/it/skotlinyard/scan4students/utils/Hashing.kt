package it.skotlinyard.scan4students.utils
import java.security.MessageDigest
import java.util.*
import javax.xml.bind.DatatypeConverter


class Hashing {

    fun sha1(input: String) = hashString("SHA-1", input)
    fun md5(input: String) = hashString("MD5", input)

    private fun hashString(type: String, input: String): String {
        val bytes = MessageDigest
            .getInstance(type)
            .digest(input.toByteArray())
        return DatatypeConverter.printHexBinary(bytes).toUpperCase(Locale.ROOT)
    }
}