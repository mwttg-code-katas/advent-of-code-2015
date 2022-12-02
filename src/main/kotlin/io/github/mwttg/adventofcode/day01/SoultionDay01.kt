package io.github.mwttg.adventofcode.day01

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val floor: Int
    val time1 = measureTimeMillis { floor = getFloor() }
    println("The instructions took Santa to floor '$floor'. This took $time1 ms.")
}

private fun getFloor() = File("./puzzle-inputs/day01/input.txt")
    .readText()
    .fold(0) { acc, item ->
        when (item) {
            ')' -> acc - 1
            '(' -> acc + 1
            else -> throw Exception("Not possible")
        }
    }