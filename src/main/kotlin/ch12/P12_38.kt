package ch12

import java.util.*

class P12_38 {

    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(elements: LinkedList<Int>, start: Int, k: Int) {
            if (k == 0) {
                result.add(elements)
                return
            }
            for (i in start..n) {
                elements.add(i)
                dfs(elements, i + 1, k - 1)
                elements.removeLast()
            }
        }


        dfs(LinkedList(), 1, k)
        return result
    }
}