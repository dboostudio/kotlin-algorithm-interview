package ch10

import io.kotest.core.spec.style.ShouldSpec

class P10_32Test : ShouldSpec({
    val P10_32 = P10_32()

    should("lengthOfLongestSubstring") {
        val result = P10_32.lengthOfLongestSubstring(" ")
        println("result = ${result}")
    }
})
