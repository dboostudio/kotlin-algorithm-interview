package ch09

import common.ListNode
import io.kotest.core.spec.style.FunSpec

class P9_27Test : FunSpec({

    val P9_27 = P9_27()

    // [[1,4,5],[1,3,4],[2,6]]
    context("mergeKLists") {
        val node11 = ListNode(1)
        val node12 = ListNode(4)
        val node13 = ListNode(5)
        node11.next = node12
        node12.next = node13
        val node21 = ListNode(1)
        val node22 = ListNode(3)
        val node23 = ListNode(4)
        node22.next = node21
        node23.next = node22
        val node31 = ListNode(2)
        val node32 = ListNode(6)
        node31.next = node32

        P9_27.mergeKLists(arrayOf(node11, node21, node31))
    }
})
