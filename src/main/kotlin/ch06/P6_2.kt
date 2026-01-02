package ch06

class P6_2 {

    fun reverseArray1(charArray: Array<Char>) {
        return charArray.reverse()
    }

    fun reverseArray2(charArray: Array<Char>) {
        var pointer1 = 0
        var pointer2 = charArray.size - 1
        while (pointer1 < pointer2) {
            charArray[pointer1] = charArray[pointer2].also { charArray[pointer1] = it }
            /*
                java 에서는 임시 변수가 필요하지만 코틀린에서는 also를 통해 변경되기 전 값을 사용가능
             */
            pointer1++
            pointer2--
        }
    }
}