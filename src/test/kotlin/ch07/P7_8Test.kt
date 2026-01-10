package ch07

import io.kotest.core.spec.style.ShouldSpec

class P7_8Test : ShouldSpec({

    val P7_8 = P7_8()
    
    context("a") {
        should("a") {
            val input = intArrayOf(1, 1, 0, 2, 1, 1, 3, 2, 1, 2, 1)
            P7_8.trappingRain(input)
        }
    }
})
