package ch06

import alphabeticAndWhiteSpace
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll
import numericAndWhiteSpace

class P6_3Test : ShouldSpec({

    val P6_3 = P6_3()

    context("sortLog1") {
        should("pass") {

            val stringLogSize = 20
            val intLogSize = 20
            val totalLogSize = stringLogSize + intLogSize
            val stringLogGen = Arb.alphabeticAndWhiteSpace(1..20)
                .filter { log -> log[0].isLetter() }
            val intLogGen = Arb.numericAndWhiteSpace(1..20)
                .filter { log -> log[0].isDigit() }

            checkAll(
                Arb.list(stringLogGen, stringLogSize..stringLogSize),
                Arb.list(intLogGen, intLogSize..intLogSize),
            ) { stringLogs, intLogs ->
                val ids = (1..totalLogSize).map { "id$it" }
                val logs = (stringLogs + intLogs)
                    .shuffled()
                    .mapIndexed { index, log ->
                        "$ids[$index] $log"
                    }

                val (intLogsAfterShuffle, stringLogsAfterShuffle) = logs.partition { it.split(' ')[1][0].isDigit() }
                val sortedStringLogs = stringLogsAfterShuffle.sortedBy { it -> it.split(' ')[1] }
                val expected = sortedStringLogs + intLogsAfterShuffle

                P6_3.sortLog1(logs) shouldBe expected
            }
        }
    }
})
