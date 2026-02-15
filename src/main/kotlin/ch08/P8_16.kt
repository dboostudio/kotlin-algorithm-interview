package ch08

import common.ListNode

class P8_16 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2

        var node = ListNode(0)
        val root = node
        var carry = 0
        while (node1 != null || node2 != null || carry != 0) {
            val value1 = node1?.`val` ?: 0
            val value2 = node2?.`val` ?: 0

            val sum = value1 + value2 + carry
            val value = sum % 10
            carry = sum / 10

            node.next = ListNode(value)
            node = node.next!!

            node1 = node1?.next
            node2 = node2?.next
        }
        return root.next
    }
}