package io.github.mwttg.adventofcode.day04

import java.security.MessageDigest
import kotlin.system.measureTimeMillis

private const val SECRET = "yzbqklnj"

fun main() {
    val lowestNumber: Long
    val time1 = measureTimeMillis { lowestNumber = mineLowestPositiveNumber() }
    println("The lowest number which results in a MD5 hash starting with '00000' is $lowestNumber. This took $time1 ms.")
}

private fun md5(input: String) = MessageDigest.getInstance("MD5").digest(input.toByteArray())

private fun ByteArray.toHex() = joinToString(separator = "") { "%02x".format(it) }

fun mineLowestPositiveNumber(): Long {
    var number = 0L
    do {
        number++
        val hash = md5("$SECRET$number").toHex()
    } while (!hash.startsWith("00000"))

    return number
}
