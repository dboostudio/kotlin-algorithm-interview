package ch06

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.Codepoint
import io.kotest.property.arbitrary.alphanumeric
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class P6_1Test : ShouldSpec({

    val P6_1 = P6_1()

    context("isPalindrome") {
        should("pass") {
            checkAll(
                iterations = 1000,
                Arb.string(10..100).filter { string ->
                    string.any { it.isLetterOrDigit() }
                },
            ) { string ->
                val alphanumericString = string.filter { it.isLetterOrDigit() }
                val reversed = string.reversed()

                val isPalindrome = alphanumericString.lowercase() == reversed.lowercase()

                P6_1.isPalindrome(string) shouldBe isPalindrome
            }
        }
        should("pass2") {
            checkAll(
                iterations = 1000,
                Arb.string(1..100, Codepoint.alphanumeric()),
            ) { string ->
                val reversedAlphanumeric = string.reversed()
                val isPalindrome = string.lowercase() == reversedAlphanumeric.lowercase()

                P6_1.isPalindrome(string) shouldBe isPalindrome
            }
        }
    }

    context("isPalindrome2") {
        should("pass") {
            checkAll(
                iterations = 1000,
                Arb.string(10..100).filter { string ->
                    string.any { it.isLetterOrDigit() }
                },
            ) { string ->
                val alphanumericString = string.filter { it.isLetterOrDigit() }
                val reversed = string.reversed()

                val isPalindrome = alphanumericString.lowercase() == reversed.lowercase()

                P6_1.isPalindrome2(string) shouldBe isPalindrome
            }
        }
        should("pass2") {
            checkAll(
                iterations = 1000,
                Arb.string(1..100, Codepoint.alphanumeric()),
            ) { string ->
                val reversedAlphanumeric = string.reversed()
                val isPalindrome = string.lowercase() == reversedAlphanumeric.lowercase()

                P6_1.isPalindrome2(string) shouldBe isPalindrome
            }
        }
    }


    context("isPalindrome3") {
        should("pass") {
            checkAll(
                iterations = 1000,
                Arb.string(10..100).filter { string ->
                    string.any { it.isLetterOrDigit() }
                },
            ) { string ->
                val alphanumericString = string.filter { it.isLetterOrDigit() }
                val reversed = string.reversed()

                val isPalindrome = alphanumericString.lowercase() == reversed.lowercase()

                P6_1.isPalindrome3(string) shouldBe isPalindrome
            }
        }
        should("pass2") {
            checkAll(
                iterations = 1000,
                Arb.string(1..100, Codepoint.alphanumeric()),
            ) { string ->
                val reversedAlphanumeric = string.reversed()
                val isPalindrome = string.lowercase() == reversedAlphanumeric.lowercase()

                P6_1.isPalindrome3(string) shouldBe isPalindrome
            }
        }
    }
})
