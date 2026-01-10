package ch07

class P7_7 {

    fun twoSum1(nums: IntArray, target: Int): IntArray {
        var num1Index = -1
        var num2Index = -1
        nums.forEachIndexed { i, num ->
            if (nums.contains(target - num)) {
                num1Index = i
                num2Index = nums.indexOf(target - num)
            }
        }
        return listOf(num1Index, num2Index).toIntArray()
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val numsMap: MutableMap<Int, Int> = mutableMapOf()
        nums.forEachIndexed { i, num ->
            if (numsMap.containsKey(target - num)) {
                return intArrayOf(numsMap[target - num]!!, i)
            }
            numsMap.put(num, i)
        }
        return intArrayOf(0, 0)
    }
}