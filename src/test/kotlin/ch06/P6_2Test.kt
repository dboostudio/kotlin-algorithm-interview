package ch06

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.array
import io.kotest.property.arbitrary.char
import io.kotest.property.checkAll

class P6_2Test : ShouldSpec({

    val P6_2 = P6_2()

    context("reverseArray1") {
        should("pass") {
            checkAll(
                Arb.array(Arb.char(), 1..20)
            ) { charArray ->
                val copyCharArray = charArray.copyOf()
                P6_2.reverseArray1(charArray) shouldBe copyCharArray.reverse()
            }
        }
    }
    context("reverseArray2") {
        should("pass") {
            checkAll(
                Arb.array(Arb.char(), 1..20)
            ) { charArray ->
                val copyCharArray = charArray.copyOf()
                P6_2.reverseArray2(charArray) shouldBe copyCharArray.reverse()
            }
        }
    }
})
