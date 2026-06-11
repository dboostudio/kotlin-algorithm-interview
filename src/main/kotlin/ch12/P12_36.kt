package ch12

class P12_36 {
    val dic: MutableMap<Char, List<Char>> = mutableMapOf(
        '0' to mutableListOf(),
        '1' to mutableListOf(),
        '2' to mutableListOf('a', 'b', 'c'),
        '3' to mutableListOf('d', 'e', 'f'),
        '4' to mutableListOf('g', 'h', 'i'),
        '5' to mutableListOf('j', 'k', 'l'),
        '6' to mutableListOf('m', 'n', 'o'),
        '7' to mutableListOf('p', 'q', 'r', 's'),
        '8' to mutableListOf('t', 'u', 'v'),
        '9' to mutableListOf('w', 'x', 'y', 'z'),
    )

    fun letterCombinations(digits: String): List<String> {
        val result: MutableList<String> = mutableListOf()

        fun dfs(index: Int, combinedString: String) {

            if (combinedString.length == digits.length) {
                result.add(combinedString)
                return
            }

            for (c in dic[digits[index]]!!) {
                dfs(index + 1, combinedString + c)
            }
        }

        dfs(0, "")
        return result
    }
}