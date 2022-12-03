package io.github.mwttg.adventofcode.day05

private val BLACKLIST = setOf("ab", "cd", "pq", "xy")
private const val VOWELS = "aeiou"

data class NiceString(val text: String) {

    fun isNiceString() =
        text.hasThreeVowels() && text.hasDoubleLetterInRow() && text.hasNoBlacklistedItem()

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
    }
}
