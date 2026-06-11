//package ch12
//
//import java.util.*
//
//class P12_ {
//    val graph
//
//    fun recursiveDFS(v: Int, discovered: MutableList<Int>): List<Int> {
//        discovered.add(v) // 방문한 value 저장
//
//        for (w in graph.get(v)) {
//            if (!discovered.contains(w)) {
//                discovered = recursiveDFS(v, discovered)
//            }
//        }
//
//        return discovered
//    }
//
//    fun iterativeBFS(start_v: Int): List<Int> {
//        val discovered = mutableListOf<Int>()
//        discovered.add(start_v)
//
//        val queue: Queue<Int> = LinkedList()
//        queue.add(start_v)
//
//        while (!queue.isEmpty()) {
//            val v = queue.poll()
//            for (w in graph.get(v)) {
//                if (!discovered.contains(w)) {
//                    discovered.add(w)
//                    queue.add(w)
//                }
//            }
//        }
//        return discovered
//    }
//
//}