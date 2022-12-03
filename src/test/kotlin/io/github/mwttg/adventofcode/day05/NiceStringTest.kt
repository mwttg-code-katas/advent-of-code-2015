package io.github.mwttg.adventofcode.day05

import io.github.mwttg.adventofcode.day05.NiceString.Companion.hasDoubleLetterInRow
import io.github.mwttg.adventofcode.day05.NiceString.Companion.hasDoublePair
import io.github.mwttg.adventofcode.day05.NiceString.Companion.hasNoBlacklistedItem
import io.github.mwttg.adventofcode.day05.NiceString.Companion.hasRepeatedLetterWithOneCharSpace
import io.github.mwttg.adventofcode.day05.NiceString.Companion.hasThreeVowels
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isFalse
import strikt.assertions.isTrue

internal class NiceStringTest {

    @Test
    fun `has three vowels`() {
        expectThat("aaa".hasThreeVowels()).isTrue()
        expectThat("aeio".hasThreeVowels()).isTrue()
        expectThat("wewewe".hasThreeVowels()).isTrue()
        expectThat("wwrtzgfvbde".hasThreeVowels()).isFalse()
    }

    @Test
    fun `has double letter in a row`() {
        expectThat("aaa".hasDoubleLetterInRow()).isTrue()
        expectThat("ababababa".hasDoubleLetterInRow()).isFalse()
        expectThat("mdfgemrr".hasDoubleLetterInRow()).isTrue()
    }

    @Test
    fun `has no blacklisted item`() {
        expectThat("efghijklm".hasNoBlacklistedItem()).isTrue()
        expectThat("efghiabjklm".hasNoBlacklistedItem()).isFalse()
        expectThat("efghixyjklm".hasNoBlacklistedItem()).isFalse()
        expectThat("efghipqjklm".hasNoBlacklistedItem()).isFalse()
    }

    @Test
    fun `has repeated letter with one char space`() {
        expectThat("afa".hasRepeatedLetterWithOneCharSpace()).isTrue()
        expectThat("aaa".hasRepeatedLetterWithOneCharSpace()).isTrue()
        expectThat("abcdefgwhwijklm".hasRepeatedLetterWithOneCharSpace()).isTrue()
        expectThat("aab".hasRepeatedLetterWithOneCharSpace()).isFalse()
    }

    @Test
    fun `has double pair`() {
        expectThat("xyxy".hasDoublePair()).isTrue()
        expectThat("aabcdefgaa".hasDoublePair()).isTrue()
        expectThat("aaa".hasDoublePair()).isFalse()
    }
}