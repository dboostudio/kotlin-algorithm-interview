package ch12

import java.util.*

class P12_40 {

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(index: Int, path: ArrayDeque<Int>) {
            result.add(ArrayList(path))

            for (i in index until nums.size) {
                path.add(nums[i])
                dfs(i + 1, path)
                path.removeLast()
            }
        }

        dfs(0, ArrayDeque())
        return result
    }
}