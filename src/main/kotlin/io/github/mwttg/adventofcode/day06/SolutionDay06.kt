package io.github.mwttg.adventofcode.day06

import java.io.File
import kotlin.system.measureTimeMillis

private const val FILENAME = "./puzzle-inputs/day06/input.txt"

fun main() {
    val grid = Grid(1000)
    val lightsOn: Int
    val time1 = measureTimeMillis {
        manipulate(grid)
        lightsOn = grid.lightOn()
    }
    println("There are `$lightsOn` activated lights. This took $time1 ms.")


}

fun manipulate(grid: Grid) = File(FILENAME)
    .readLines()
    .map { Command.createFrom(it) }
    .forEach {
        when (it.action) {
            Action.TURN_ON -> grid.turnOn(it.left, it.bottom, it.right, it.top)
            Action.TURN_OFF -> grid.turnOff(it.left, it.bottom, it.right, it.top)
            Action.TOGGLE -> grid.toggle(it.left, it.bottom, it.right, it.top)
        }
    }

