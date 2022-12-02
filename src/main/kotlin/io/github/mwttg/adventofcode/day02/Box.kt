package io.github.mwttg.adventofcode.day02

data class Box(val length: Int, val width: Int, val height: Int) {

    private fun getSmallest() = arrayOf(length * width, width * height, height * length).min()

    private fun getSurfaceArea() =
        (2 * length * width) + (2 * width * height) + (2 * height * length)

    fun getTotal() = getSurfaceArea() + getSmallest()

    companion object {

        fun createFrom(input: String): Box {
            val splits = input.split("x")
            return Box(splits[0].toInt(), splits[1].toInt(), splits[2].toInt())
        }
    }
}
