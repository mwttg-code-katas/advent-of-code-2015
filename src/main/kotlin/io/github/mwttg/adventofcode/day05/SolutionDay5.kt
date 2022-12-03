package io.github.mwttg.adventofcode.day05

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day05/input.txt"

fun main() {
    val niceStrings: Int
    val time1 = measureTimeMillis { niceStrings = countNiceStrings() }
    println("There are `$niceStrings` nice Strings on Santa's text file. This took $time1 ms.")
}

private fun countNiceStrings() = File(FILENAME)
    .readLines()
    .map { NiceString(it) }
    .count { it.isNiceString() }