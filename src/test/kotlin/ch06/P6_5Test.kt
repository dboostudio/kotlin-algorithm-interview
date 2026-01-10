package ch06

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.map
import io.kotest.property.checkAll

class P6_5Test : ShouldSpec({

    val P6_5 = P6_5()

    context("groupAnagram") {
        should("pass") {
            checkAll(
                Arb.map(Arb.alphabetic(3..3), Arb.int(1..3), 3, 5)
            ) { anagramSources ->
                var inputArray: ArrayList<String> = ArrayList()
                val expected = buildList {
                    anagramSources.forEach { (source, repeat) ->
                        val sourceArray = source.toCharArray()
                        val groupedAnagram = buildList {
                            (1..repeat).forEach { i ->
                                sourceArray.shuffle()
                                add(sourceArray.joinToString(""))
                            }
                        }
                        add(groupedAnagram)
                        inputArray.addAll(groupedAnagram)
                    }
                }

                val result = P6_5.groupAnagram(inputArray.toTypedArray())
                result shouldBe expected
            }
        }
    }

})
