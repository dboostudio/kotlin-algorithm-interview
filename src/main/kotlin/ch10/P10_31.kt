package ch10

class P10_31 {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val map = mutableMapOf<Char, Int>()
        for (jewel in jewels) {
            map.put(jewel, 0)
        }

        for (stone in stones) {
            if (map.containsKey(stone)) {
                map.put(stone, map.getOrDefault(stone, 0) + 1)
            }
        }

        return map.values.sum()
    }
}