package io.github.mwttg.adventofcode.day02

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day02/input.txt"

fun main() {
    val total: Int
    val time1 = measureTimeMillis { total = getTotal() }
    println("The Elves should order '$total' square feet of wrapping paper. This took $time1 ms.")

    val ribbon: Int
    val time2 = measureTimeMillis { ribbon = getRibbon() }
    println("The Elves should order '$ribbon' feet of ribbon. This took $time2 ms.")
}

private fun getTotal() = getBoxes().sumOf { it.getTotal() }

private fun getRibbon() = getBoxes().sumOf { it.getTotalRibbon() }

private fun getBoxes() = File(FILENAME)
    .readLines()
    .map { Box.createFrom(it) }