package ch12

import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.MutableList

class P12_37 {

    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(prev: MutableList<Int>, elements: MutableList<Int>) {
            if (elements.isEmpty()) {
                result.add(prev.toList())
                return
            }

            for (e in elements) {
                val nextElements = ArrayList(elements)
                nextElements.remove(e)
                prev.add(e)

                dfs(prev, nextElements)
                prev.remove(e)
            }
        }

        dfs(mutableListOf(), nums.toMutableList())
        return result
    }
}