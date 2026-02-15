package ch09

import java.util.*

class P9_24 {
}

class MyQueue(
    val mainStack: Stack<Int> = Stack(),
    val subStack: Stack<Int> = Stack(),
) {
    fun push(x: Int) {
        subStack.push(x)
    }

    fun pop(): Int {
        peek()
        return mainStack.pop()
    }

    fun peek(): Int {
        if (mainStack.isEmpty()) {
            while (!subStack.isEmpty()) {
                mainStack.push(subStack.pop())
            }
        }
        return mainStack.peek()
    }

    fun empty(): Boolean {
        return (mainStack.isEmpty() && subStack.isEmpty())
    }
}