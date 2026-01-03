package ch06

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.constant
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.flatMap
import io.kotest.property.arbitrary.triple
import io.kotest.property.checkAll

class P6_6Test : ShouldSpec({

    val P6_6 = P6_6()

    context("longestPalindrome") {
        should("pass") {

            val palindromeSizeRange = 15..20
            val palindromeGen = Arb.alphabetic(palindromeSizeRange).flatMap {
                Arb.constant(it + it.reversed())
            }

            val prefixAndPalindromeAndPostfixGen =
                palindromeGen.flatMap { palindrome ->
                    val prefixGen = Arb.alphabetic(5..10)
                        .filter { it.last() != palindrome.last() }
                    val tripleGen = prefixGen.flatMap { prefix ->
                        Arb.alphabetic(5..10)
                            .filter { it.first() !in listOf(prefix.last(), palindrome.first()) }
                            .flatMap {
                                Arb.triple(
                                    Arb.constant(prefix),
                                    Arb.constant(palindrome),
                                    Arb.constant(it)
                                )
                            }
                    }
                    tripleGen
                }

            checkAll(
                iterations = 1000000,
                prefixAndPalindromeAndPostfixGen
            ) { (prefix, palindrome, postfix) ->
                val string = prefix + palindrome + postfix

                P6_6.longestPalindrome(string) shouldBe palindrome
            }
        }
    }
})
