package ch09

import java.util.*

class P9_20 {

    fun isValidBrackets(s: String): Boolean {
        val brackets = mapOf('(' to ')', '{' to '}', '[' to ']')
        val stack = Stack<Char>()
        for (c in s) {
            if (stack.isEmpty()) {
                stack.push(c)
                continue
            }
            val peek = stack.peek()
            if (brackets[peek] == c) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        return stack.isEmpty()
    }
}