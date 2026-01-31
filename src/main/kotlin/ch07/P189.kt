package ch07

class P189 {

    fun rotate(nums: IntArray, k: Int) {
        if (nums.size == 1) return
        val copyArray = nums.copyOf()
        val shift = k % nums.size

        for (i in nums.indices) {
            var shiftedIndex = i + shift
            if (shiftedIndex > nums.lastIndex) shiftedIndex -= (nums.lastIndex + 1)
            nums[shiftedIndex] = copyArray[i]
        }
    }
}