package ch08

import common.ListNode
import java.util.*

class P8_15 {
    fun reverseList(head: ListNode?): ListNode? {
        return reverse(head, null)
    }

    fun reverse(node: ListNode?, prev: ListNode?): ListNode? {
        if (node == null) return prev
        val next = node.next
        node.next = prev
        return reverse(next, prev)
    }

    fun reversetList2(head: ListNode?): ListNode? {
        if (head == null) return head
        val stack = Stack<ListNode>()
        var node = head
        while (node != null) {
            stack.push(node)
            val next = node.next
            node.next = null
            node = next
        }

        val result = stack.pop()
        var reverseNode = result
        while (stack.isNotEmpty()) {
            reverseNode.next = stack.pop()
            reverseNode = reverseNode.next
        }
        return result
    }

    fun reversetList3(head: ListNode?): ListNode? {
        if (head == null) return head
        val stack = Stack<ListNode>()
        var node = head
        while (node != null) {
            stack.push(ListNode(node.`val`))
            node = node.next
        }

        val result = stack.pop()
        var reverseNode = result
        while (stack.isNotEmpty()) {
            reverseNode.next = stack.pop()
            reverseNode = reverseNode.next
        }
        return result
    }

}