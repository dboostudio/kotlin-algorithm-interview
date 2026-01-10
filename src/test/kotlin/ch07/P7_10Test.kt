package ch07

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.set
import io.kotest.property.checkAll

class P7_10Test : ShouldSpec({

    val P7_10 = P7_10()

    context("maxSumOfPairMin") {
        should("return max sum for min of pair") {
            checkAll(
                Arb.set(Arb.int(1..100), 3..10)
                    .map { it.toIntArray() },
            ) { intArray ->
                val sorted = intArray.sorted()
                var expected = 0
                for (i in 0..sorted.lastIndex step 2) {
                    expected += sorted[i]
                }

                val result1 = P7_10.maxSumOfPairMin1(intArray)
                val result2 = P7_10.maxSumOfPairMin2(intArray)

                result1 shouldBe expected
                result2 shouldBe expected
            }
        }
    }

})
