package ch09

import common.ListNode
import java.util.*

class P9_27 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val priorityQueue = PriorityQueue<ListNode> { o1, o2 ->
            when {
                o1.`val` == o2.`val` -> 0
                o1.`val` > o2.`val` -> 1
                else -> -1
            }
        }

        for (list in lists) {
            if (list != null)
                priorityQueue.add(list)
        }

        val rootNode = ListNode(0)
        var tail: ListNode = rootNode

        while (!priorityQueue.isEmpty()) {
            val poll = priorityQueue.poll()
            if (poll != null) {
                tail.next = poll
                tail = tail.next!!
            }
            priorityQueue.add(tail.next)
        }

        return rootNode.next
    }
}