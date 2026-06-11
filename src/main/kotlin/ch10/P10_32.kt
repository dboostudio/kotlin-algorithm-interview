package ch10

class P10_32 {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var maxLength = 0

        if (s.length == 1) return 1

        val charPositions = mutableMapOf<Int, Char>()
        for (i in 0 until s.length) {
            charPositions.put(i, s[i])
        }

        val seen = mutableMapOf<Char, Int>()

        for (charPosition in charPositions) {
            val (position, char) = charPosition
            val sawPosition = seen[char]
            if (sawPosition != null && sawPosition > start) {
                start = seen[char]!! + 1
            }

            seen.put(char, position)
            maxLength = Math.max(maxLength, position - start)
        }

        return maxLength
    }
}