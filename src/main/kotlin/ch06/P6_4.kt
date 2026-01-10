package ch06

class P6_4 {

    fun getMostFrequentWord(paragraph: String): String {
        val split = paragraph.split(" ")
        val wordToCount = buildMap { // word to count
            split.forEach { word ->
                val prevCount = get(word) ?: 0
                put(word, prevCount + 1)
            }
        }
        return wordToCount.maxBy { it.value }.key
    }
}