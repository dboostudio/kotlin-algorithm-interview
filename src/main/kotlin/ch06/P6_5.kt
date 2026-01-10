package ch06

class P6_5 {
    fun groupAnagram(strArray: Array<String>): List<List<String>> {
        val keyToStrings = buildMap {
            for (str in strArray) {
                val sortedStr = str.toCharArray().sorted().joinToString("")
                val prevList = get(sortedStr) ?: listOf()
                put(sortedStr, prevList + listOf(str))
            }
        }
        return ArrayList(keyToStrings.values)
    }
}