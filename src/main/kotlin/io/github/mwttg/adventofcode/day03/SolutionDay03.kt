package io.github.mwttg.adventofcode.day03

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day03/input.txt"

fun main() {
    val houses: Int
    val time1 = measureTimeMillis { houses = getAmountOfHouses() }
    println("'$houses' will get at least one present. This took $time1 ms.")

}

fun getAmountOfHouses() = File(FILENAME)
    .readText()
    .scan(Position(0, 0)) { acc, item ->
        when (item) {
            '^' -> acc.moveUp()
            'v' -> acc.moveDown()
            '<' -> acc.moveLef()
            '>' -> acc.moveRight()
            else -> throw Exception("not possible. found item '$item'")
        }
    }
    .toSet()
    .count()