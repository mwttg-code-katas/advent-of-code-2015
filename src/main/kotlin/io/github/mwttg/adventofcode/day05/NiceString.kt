package io.github.mwttg.adventofcode.day05

private val BLACKLIST = setOf("ab", "cd", "pq", "xy")
private const val VOWELS = "aeiou"

data class NiceString(val text: String) {

    fun isNiceString() =
        text.hasThreeVowels() && text.hasDoubleLetterInRow() && text.hasNoBlacklistedItem()

    fun isNiceStringV2() = text.hasRepeatedLetterWithOneCharSpace() && text.hasDoublePair()

    companion object {

        fun String.hasThreeVowels() = this.filter { VOWELS.contains(it) }.length >= 3

        fun String.hasDoubleLetterInRow(): Boolean {
            var lastC = 'ß'
            for (c in this) {
                if (c != lastC) {
                    lastC = c
                    continue
                } else {
                    return true
                }
            }
            return false
        }

        fun String.hasNoBlacklistedItem() = BLACKLIST.none { this.contains(it) }

        fun String.hasRepeatedLetterWithOneCharSpace(): Boolean {
            for (index in 2 until this.length) {
                val lastChar = this[index - 2]
                val c = this[index]
                if (c == lastChar) {
                    return true
                }
            }
            return false
        }

        fun String.hasDoublePair(): Boolean {
            for (index in 1 until this.length) {
                val pair = "${this[index - 1]}${this[index]}"
                val subStr = this.substring(index + 1)
                if (subStr.contains(pair)) {
                    return true
                }
            }
            return false
        }
    }
}
