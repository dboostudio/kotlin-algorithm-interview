package ch07

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class P7_11Test : ShouldSpec({

    val P7_11 = P7_11()

    context("multiplyExceptSelf") {
        should("pass") {
            val array = intArrayOf(1, 3, 5, 7)
            val expected = intArrayOf(105, 35, 21, 15)
            P7_11.productExceptSelf(array) shouldBe expected
        }
    }

    context("productExceptSelf2") {
        should("pass") {
            val array = intArrayOf(1, 3, 5, 7)
            val expected = intArrayOf(105, 35, 21, 15)
            P7_11.productExceptSelf2(array) shouldBe expected
        }
    }
})
