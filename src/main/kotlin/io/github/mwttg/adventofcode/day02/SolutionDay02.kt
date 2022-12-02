package io.github.mwttg.adventofcode.day02

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day02/input.txt"

fun main() {
    val total: Int
    val time1 = measureTimeMillis { total = getTotal() }
    println("The Elves should order '$total' square feet of wrapping paper. This took $time1 ms.")
}

private fun getTotal() = File(FILENAME)
    .readLines()
    .map { Box.createFrom(it) }
    .sumOf { it.getTotal() }