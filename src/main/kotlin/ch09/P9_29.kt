package ch09

import java.util.*

class P9_29 {
    fun scoville(scovilles: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>()
        for (scoville in scovilles) {
            queue.add(scoville)
        }

        var answer = 0

        while (queue.size > 1 && queue.peek() < k) {
            val new = queue.poll() + queue.poll() * 2
            queue.add(new)
            answer += 1
        }

        if (queue.peek() >= k) return answer

        return -1
    }
}