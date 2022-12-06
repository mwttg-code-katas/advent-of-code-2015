package io.github.mwttg.adventofcode.day06

enum class Action {
    TURN_ON,
    TURN_OFF,
    TOGGLE;

    companion object {

        fun createFrom(text: String) = when (text) {
            "turn on" -> TURN_ON
            "turn off" -> TURN_OFF
            "toggle" -> TOGGLE
            else -> throw Exception("Not possible")
        }
    }
}

data class Command(
    val action: Action,
    val left: Int,
    val bottom: Int,
    val right: Int,
    val top: Int
) {

    companion object {

        private val regexPattern =
            "(turn off|turn on|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)".toRegex()

        fun createFrom(line: String) =
            regexPattern
                .find(line)
                .let { match ->
                    val (action, left, bottom, right, top) = match!!.destructured
                    Command(
                        action = Action.createFrom(action),
                        left = left.toInt(),
                        bottom = bottom.toInt(),
                        right = right.toInt(),
                        top = top.toInt()
                    )
                }
    }
}
