package ch09

import java.util.*

class P9_22 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {

        val dayToLeftDays = mutableMapOf<Int, Int>()
        val indexStack = Stack<Int>()

        for (i in temperatures.indices) {
            while (!indexStack.empty() && temperatures[indexStack.peek()] < temperatures[i]) {
                val index = indexStack.pop()
                dayToLeftDays.put(index, i - index)
            }

            indexStack.push(i)
        }
        while (!indexStack.empty()) {
            val pop = indexStack.pop()
            dayToLeftDays.put(pop, 0)
        }

        return dayToLeftDays.toSortedMap().values.toTypedArray().toIntArray()
    }
}