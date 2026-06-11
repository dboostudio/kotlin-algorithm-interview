package ch12

import java.util.*

class P12_42 {
    fun findTravelWay(tickets: List<List<String>>): Array<String> {
        val fromToMap: MutableMap<String, PriorityQueue<String>> = mutableMapOf()

        for (ticket in tickets) {
            fromToMap.putIfAbsent(ticket[0], PriorityQueue<String>())
            fromToMap[ticket[0]]!!.add(ticket[1])
        }

        val results: MutableList<String> = LinkedList()
        val stack: ArrayDeque<String> = ArrayDeque()

        stack.push("ICN")

        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.first) && !fromToMap[stack.first]!!.isEmpty()) {
                stack.push(fromToMap[stack.first]!!.poll())
            }

            results.add(0, stack.pop())
        }

        return results.toTypedArray()
    }
}