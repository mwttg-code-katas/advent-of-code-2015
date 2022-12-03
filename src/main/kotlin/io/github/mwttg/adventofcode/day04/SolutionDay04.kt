package io.github.mwttg.adventofcode.day04

import java.security.MessageDigest
import kotlin.system.measureTimeMillis

private const val SECRET = "yzbqklnj"

fun main() {
    val lowestNumber5: Long
    val time1 = measureTimeMillis { lowestNumber5 = mineLowestPositiveNumber("00000") }
    println("The lowest number which results in a MD5 hash starting with '00000' is $lowestNumber5. This took $time1 ms.")

    val lowestNumber6: Long
    val time2 = measureTimeMillis { lowestNumber6 = mineLowestPositiveNumber("000000") }
    println("The lowest number which results in a MD5 hash starting with '000000' is $lowestNumber6. This took $time2 ms.")
}

private fun md5(input: String) = MessageDigest.getInstance("MD5").digest(input.toByteArray())

private fun ByteArray.toHex() = joinToString(separator = "") { "%02x".format(it) }

fun mineLowestPositiveNumber(start: String): Long {
    var number = 0L
    do {
        number++
        val hash = md5("$SECRET$number").toHex()
    } while (!hash.startsWith(start))

    return number
}
