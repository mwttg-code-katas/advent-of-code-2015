package io.github.mwttg.adventofcode.day06

class Grid(private val size: Int) {

    var content = Array(size) { BooleanArray(size) { false } }

    fun turnOn(left: Int, bottom: Int, right: Int, top: Int) {
        for (y in bottom..top) {
            for (x in left..right) {
                content[y][x] = true
            }
        }
    }

    fun turnOff(left: Int, bottom: Int, right: Int, top: Int) {
        for (y in bottom..top) {
            for (x in left..right) {
                content[y][x] = false
            }
        }
    }

    fun toggle(left: Int, bottom: Int, right: Int, top: Int) {
        for (y in bottom..top) {
            for (x in left..right) {
                content[y][x] = !content[y][x]
            }
        }
    }

    fun lightOn() = content.sumOf { row ->
        row.count {
            it
        }
    }
}