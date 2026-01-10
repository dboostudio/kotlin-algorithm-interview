package ch07


class P7_9 {
    fun tripleSumToZero(nums: IntArray): List<IntArray> {

        val sorted = nums.distinct().sorted()

        return buildList {
            for (i in 0..sorted.size - 3) {
                var left = i + 1
                var right = sorted.size - 1
                val current = sorted[i]

                while (left < right) {
                    val leftValue = sorted[left]
                    val rightValue = sorted[right]
                    val sum = leftValue + rightValue + current
                    if (sum > 0) {
                        right--
                    } else if (sum < 0) {
                        left++
                    } else {
                        add(intArrayOf(leftValue, current, rightValue))
                        right--
                        left++
                    }
                }
            }
        }
    }
}