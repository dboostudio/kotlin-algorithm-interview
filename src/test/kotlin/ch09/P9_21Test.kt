package ch09

import io.kotest.core.spec.style.ShouldSpec

class P9_21Test : ShouldSpec({

    val P9_21 = P9_21()

    context("removeDuplicateAndGetRexicographicalLetters") {
        should("pass") {
            val result =
                P9_21.removeDuplicateAndGetRexicographicalLetters("dbacdcbc")

            println("result = ${result}")
        }
    }
})
