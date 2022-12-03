package io.github.mwttg.adventofcode.day03

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day03/input.txt"

fun main() {
    val houses: Int
    val time1 = measureTimeMillis { houses = getAmountOfHouses() }
    println("'$houses' will get at least one present. This took $time1 ms.")

    val houses2: Int
    val time2 = measureTimeMillis { houses2 = getTurnedBasedAmountOfHouses() }
    println("'$houses2' will get at least one present. This took $time2 ms.")

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

fun getTurnedBasedAmountOfHouses() = File(FILENAME)
    .readText()
    .foldIndexed(
        listOf(
            mutableListOf(Position(0, 0)),
            mutableListOf(Position(0, 0)),
        )
    ) { index, acc, item ->
        val robotTurn = index % 2 == 0
        val setIndex = if (robotTurn) 1 else 0
        val lastPosition = acc[setIndex].last()
        val newPosition = when (item) {
            '^' -> lastPosition.moveUp()
            'v' -> lastPosition.moveDown()
            '<' -> lastPosition.moveLef()
            '>' -> lastPosition.moveRight()
            else -> throw Exception("not possible. found item '$item'")
        }
        acc[setIndex].add(newPosition)

        acc
    }
    .fold(mutableSetOf(Position(0, 0))) { acc, item ->
        val newAcc = acc.union(item)
        newAcc.toMutableSet()
    }
    .count()