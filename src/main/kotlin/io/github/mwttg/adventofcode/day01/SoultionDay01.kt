package io.github.mwttg.adventofcode.day01

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day01/input.txt"

fun main() {
    val floor: Int
    val time1 = measureTimeMillis { floor = getFloor() }
    println("The instructions took Santa to floor '$floor'. This took $time1 ms.")

    val position: Int
    val time2 = measureTimeMillis { position = getPositionToBasement() }
    println("The position the first time Santa entered the basement was '$position'. This took $time2 ms.")
}

private fun getFloor() = File(FILENAME)
    .readText()
    .fold(0) { acc, item -> updateFloor(item, acc) }

private fun getPositionToBasement() = File(FILENAME)
    .readText()
    .scan(0) { acc, item -> updateFloor(item, acc) }
    .indexOfFirst { it == -1 }

private fun updateFloor(item: Char, currentFloor: Int) = when (item) {
    ')' -> currentFloor - 1
    '(' -> currentFloor + 1
    else -> throw Exception("Not possible")
}