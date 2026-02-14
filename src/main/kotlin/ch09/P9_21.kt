package ch09

import java.util.*

class P9_21 {
    fun removeDuplicateAndGetRexicographicalLetters(s: String): String {
        // dbacdcbc
        // c / c b -> b

        val seen = mutableMapOf<Char, Boolean>()
        val counter = mutableMapOf<Char, Int>()
        val stack: Stack<Char> = Stack()

        for (c in s) {
            val count = counter.getOrDefault(c, 0)
            counter.put(c, count + 1)
        }

        for (c in s) {
            counter[c] = counter[c]!! - 1

            if (seen[c] == true) {
                continue
            }

            while (!stack.isEmpty() && stack.peek() > c && counter[stack.peek()]!! > 0) {
                seen[stack.pop()] = false
            }
            stack.push(c)
            seen[c] = true
        }

        return buildString {
            while (!stack.isEmpty()) {
                insert(0, stack.pop())
            }
        }
    }
}