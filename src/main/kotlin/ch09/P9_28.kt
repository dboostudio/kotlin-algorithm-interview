package ch09

import java.util.*
import kotlin.math.pow

class P9_28 {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val priorityQueue = PriorityQueue<IntArray> { t1, t2 ->
            val distance1 = t1[0].toDouble().pow(2.0) + t1[1].toDouble().pow(2.0)
            val distance2 = t2[0].toDouble().pow(2.0) + t2[1].toDouble().pow(2.0)

            distance1.compareTo(distance2)
        }
        priorityQueue.addAll(points)
        val result: Array<IntArray> = Array(k) { IntArray(2) }
        for (i in 0 until k) {
            result[i] = priorityQueue.poll()
        }
        return result
    }
}