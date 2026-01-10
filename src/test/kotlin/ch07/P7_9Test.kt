package ch07

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.intArray
import io.kotest.property.checkAll

class P7_9Test : ShouldSpec({

    val P7_9 = P7_9()

    context("tripleSumToZero") {
        should("return triples which sum is zero") {
            checkAll(
                Arb.intArray(Arb.int(3..20), Arb.int(-100..100))
            ) { nums ->
                val results = P7_9.tripleSumToZero(nums)

                results.forEach { result ->
                    val sum = result.sum()
                    sum shouldBe 0
                }
            }
        }
    }
})
