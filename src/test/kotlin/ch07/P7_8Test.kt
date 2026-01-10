package ch07

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class P7_8Test : ShouldSpec({

    val P7_8 = P7_8()

    context("trappingRain") {
        should("return rains volume") {
            val input = intArrayOf(1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
            val expected = 6
            val trappingRain1 = P7_8.trappingRain1(input)
            val trappingRain2 = P7_8.trappingRain2(input);

            trappingRain1 shouldBe expected
            trappingRain2 shouldBe expected

        }
    }
})
