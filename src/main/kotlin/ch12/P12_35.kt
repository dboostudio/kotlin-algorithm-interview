package ch12

class P12_35 {

    fun numIsland(grid: Array<CharArray>): Int {

        fun dfs(i: Int, j: Int) {
            when {
                (i < 0) ||
                        (i >= grid.size) ||
                        (j < 0) ||
                        (j >= grid[0].size) ||
                        (grid[i][j] == '0') -> return
            }

            grid[i][j] = '0'

            dfs(i, j + 1)
            dfs(i, j - 1)
            dfs(i + 1, j)
            dfs(i, j + 1)
        }

        var count = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    dfs(i, j)
                    count++
                }
            }
        }

        return count
    }
}