package io.github.mwttg.adventofcode.day03

data class Position(val x: Int, val y: Int) {

    fun moveUp() = this.copy(y = this.y + 1)

    fun moveDown() = this.copy(y = this.y - 1)

    fun moveRight() = this.copy(x = this.x + 1)

    fun moveLef() = this.copy(x = this.x - 1)
}
