package ch08

import java.util.*

class P8_13 {
    fun isPalindrome(head: ListNode?): Boolean {
        val deque: Deque<Int> = LinkedList()
        var node = head
        while (node != null) {
            deque.add(node.`val`)
            node = node.next
        }

        while (deque.isNotEmpty()) {
            if (deque.size == 1) return true
            val first = deque.pollFirst()
            val last = deque.pollLast()
            if (first != last) return false
        }
        return true
    }
}

