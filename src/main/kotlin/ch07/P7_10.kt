package ch07

class P7_10 {

    fun maxSumOfPairMin1(array: IntArray): Int {
        var sum = 0
        val sorted = array.sorted()
        // iterate even number
        for (i in 0..sorted.lastIndex step 2) {
            sum += sorted[i]
        }
        return sum
    }

    fun maxSumOfPairMin2(array: IntArray): Int {
        var sum = 0
        array.sort()
        for ((i, n) in array.withIndex()) {
            if (i % 2 == 0) sum += n
        }
        return sum
    }
}