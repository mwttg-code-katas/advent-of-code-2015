package io.github.mwttg.adventofcode.day06

// TODO generic Grid ??
class ModifiedGrid(private val size: Int) {

    private var content = Array(size) { IntArray(size) { 0 } }

    fun turnOn(left: Int, bottom: Int, right: Int, top: Int) {
        for (y in bottom..top) {
            for (x in left..right) {
                content[y][x] = content[y][x] + 1
            }
        }
    }

    fun turnOff(left: Int, bottom: Int, right: Int, top: Int) {
        for (y in bottom..top) {
            for (x in left..right) {
                content[y][x] = if (content[y][x] == 0) 0 else content[y][x] - 1
            }
        }
    }

    fun toggle(left: Int, bottom: Int, right: Int, top: Int) {
        for (y in bottom..top) {
            for (x in left..right) {
                content[y][x] = content[y][x] + 2
            }
        }
    }

    fun lightOn() = content.sumOf { it.sum() }
}