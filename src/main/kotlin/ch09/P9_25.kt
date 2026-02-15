package ch09

import java.util.*

class P9_25 {

}

class MyCircularQueue(
    val k: Int,
) {
    val deque: ArrayDeque<Int> = ArrayDeque()

    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        deque.addLast(value)
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }
        deque.removeFirst()
        return true
    }

    fun Front(): Int {
        if (isEmpty()) return -1
        return deque.first()
    }

    fun Rear(): Int {
        if (isEmpty()) return -1
        return deque.last()
    }

    fun isEmpty(): Boolean {
        return deque.isEmpty()
    }

    fun isFull(): Boolean {
        return deque.size == k
    }

}
