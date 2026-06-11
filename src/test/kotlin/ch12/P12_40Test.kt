package ch12

import io.kotest.core.spec.style.ShouldSpec

class P12_40Test : ShouldSpec({

    val P12_40 = P12_40()

    should("p12_40") {
        val input = intArrayOf(1, 2, 3)
        val result = P12_40.subsets(input)
        println("result = ${result}")
    }

})
