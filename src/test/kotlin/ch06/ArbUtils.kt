package ch06

import io.kotest.property.Arb
import io.kotest.property.arbitrary.Codepoint
import io.kotest.property.arbitrary.of
import io.kotest.property.arbitrary.string

fun Arb.Companion.numeric(range: IntRange) = Arb.string(range, Codepoint.numeric())
fun Codepoint.Companion.numeric(): Arb<Codepoint> =
    Arb.of(
        ('0'..'9').map { Codepoint(it.code) }
    )

fun Arb.Companion.alphabetic(range: IntRange) = Arb.string(range, Codepoint.alphabetic())
fun Codepoint.Companion.alphabetic(): Arb<Codepoint> =
    Arb.of(
        (('a'..'z') + ('A'..'Z')).map { Codepoint(it.code) }
    )

fun Arb.Companion.alphabeticAndWhiteSpace(range: IntRange) = Arb.string(range, Codepoint.alphabeticAndWhiteSpace())
fun Codepoint.Companion.alphabeticAndWhiteSpace(): Arb<Codepoint> =
    Arb.of(
        (listOf(' ') + ('a'..'z') + ('A'..'Z')).map { Codepoint(it.code) }
    )

fun Arb.Companion.numericAndWhiteSpace(range: IntRange) = Arb.string(range, Codepoint.numericAndWhiteSpace())
fun Codepoint.Companion.numericAndWhiteSpace(): Arb<Codepoint> =
    Arb.of(
        (listOf(' ') + ('0'..'9')).map { Codepoint(it.code) }
    )


