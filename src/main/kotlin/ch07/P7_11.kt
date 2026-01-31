package ch07

class P7_11 {

    // time limit exceed O(n^2)
    fun productExceptSelf(nums: IntArray): IntArray {
        val list = nums.toList()
        return buildList {
            list.forEachIndexed { index, number ->
                val exceptSelf = list.filterIndexed { i, _ -> i != index }
                val multiply = exceptSelf.reduce { a, b -> a * b }
                add(multiply)
            }
        }.toIntArray()
    }

    fun productExceptSelf2(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        var multiply = 1
        for (i in nums.indices) {
            result[i] *= multiply
            multiply *= nums[i]
        }
        multiply = 1
        for (i in nums.lastIndex downTo 0) {
            result[i] *= multiply
            multiply *= nums[i]
        }
        return result
    }
}