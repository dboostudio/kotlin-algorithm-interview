package ch07

import java.util.*

class P7_8 {
    fun trappingRain1(heights: IntArray): Int {
        val stack: Deque<Int> = ArrayDeque()
        var volume = 0
        heights.forEachIndexed { i, height ->
            while (stack.isNotEmpty() && height > heights[stack.peek()]) {
                val prev = stack.pop()
                if (stack.isEmpty()) break

                val distance = i - stack.peek() - 1
                val waters = Math.min(heights[i], heights[stack.peek()]) - heights[prev]
                volume += waters * distance
            }
            stack.push(i)
        }
        return volume
    }

    fun trappingRain2(heights: IntArray): Int {
        var left = 0
        var right = heights.lastIndex

        var volume = 0

        var leftMax = heights[left]
        var rightMax = heights[right]

        while (left < right) {
            leftMax = leftMax.coerceAtLeast(heights[left])
            rightMax = rightMax.coerceAtLeast(heights[right])

            if (leftMax <= rightMax) {
                volume += leftMax - heights[left]
                left++
            } else {
                volume += rightMax - heights[right]
                right--
            }

        }
        return volume
    }
}