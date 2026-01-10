package ch06

import alphabetic
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.set
import io.kotest.property.checkAll

class P6_4Test : ShouldSpec({

    val P6_4 = P6_4()

    context("getMostFrequentWord") {
        should("return most frequent word") {
            checkAll(
                Arb.set(Arb.alphabetic(3..10), 1..20).map { it.toList() },
            ) { distinctWords ->
                val mostFrequentWord = distinctWords.shuffled().first()
                val input = (distinctWords + listOf(mostFrequentWord, mostFrequentWord)).joinToString(" ")
                val result = P6_4.getMostFrequentWord(input)
                result shouldBe mostFrequentWord
            }
        }
    }
})