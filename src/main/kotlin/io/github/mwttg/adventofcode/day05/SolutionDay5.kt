package io.github.mwttg.adventofcode.day05

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day05/input.txt"

fun main() {
    val niceStrings: Int
    val time1 = measureTimeMillis { niceStrings = countNiceStrings() }
    println("There are `$niceStrings` nice Strings on Santa's text file. This took $time1 ms.")

    val niceStringsV2: Int
    val time2 = measureTimeMillis { niceStringsV2 = countNiceStringsV2() }
    println("There are `$niceStringsV2` nice Strings on Santa's text file with version 2. This took $time2 ms.")
}

private fun countNiceStrings() = File(FILENAME)
    .readLines()
    .map { NiceString(it) }
    .count { it.isNiceString() }

private fun countNiceStringsV2() = File(FILENAME)
    .readLines()
    .map { NiceString(it) }
    .count { it.isNiceStringV2() }