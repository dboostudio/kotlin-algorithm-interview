package ch12

class P12_43 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // adj[v] = v를 선수과목으로 가진 강의들 (v를 들으면 풀리는 강의들)
        val adj: Array<MutableList<Int>> = Array(numCourses) { mutableListOf<Int>() }
        val indegree = IntArray(numCourses)  // 각 강의의 선수과목 개수

        for ((course, pre) in prerequisites) {
            // course를 들으려면 pre가 필요함
            adj[pre].add(course)   // pre를 들으면 course가 풀린다
            indegree[course]++     // course의 선수과목 +1
        }

        // 1) 선수과목이 없는 강의(진입차수 0)를 큐에 넣기
        val queue = ArrayDeque<Int>()
        for (course in 0 until numCourses) {
            if (indegree[course] == 0) queue.add(course)
        }

        var taken = 0  // 지금까지 들은 강의 수

        // 2) 들을 수 있는 강의를 하나씩 꺼내면서 처리
        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            taken++

            // 이 강의를 들었으니, 이걸 선수과목으로 갖던 강의들의 진입차수 감소
            for (next in adj[course]) {
                indegree[next]--
                if (indegree[next] == 0) queue.add(next)  // 이제 들을 수 있음
            }
        }

        // 3) 모든 강의를 다 들었으면 true, 못 들었으면(순환) false
        return taken == numCourses
    }
}