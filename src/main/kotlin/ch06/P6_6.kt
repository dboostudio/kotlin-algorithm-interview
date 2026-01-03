package ch06

class P6_6 {

    fun longestPalindrome(s: String): String {
        val byWindowSize2 = searchPalindromeByWindowSize(s, 2)
        val byWindowSize3 = searchPalindromeByWindowSize(s, 3)

        return if (byWindowSize2.length > byWindowSize3.length) byWindowSize2 else byWindowSize3
    }

    private fun searchPalindromeByWindowSize(s: String, windowSize: Int): String {
        var pointer1 = 0
        var pointer2 = 0 + windowSize

        var longestPalindromeInWindow = ""

        while (pointer2 < s.length) {
            // 다음 탐색할 palindrome 의 낙관적 최대길이 (palindrome중심으로부터 남은길이의 두배)
            val optimismMaxsizeOfNextPalindrome = s.length * 2 - (pointer1 + pointer2)

            // 이미 탐색된 최장길이 palindrome이 다음 탐색의 낙관적 최대길이보다 길다면 즉시 리턴
            if (longestPalindromeInWindow.length > optimismMaxsizeOfNextPalindrome) {
                return longestPalindromeInWindow
            }

            val nextPalindrome = checkPalindromeAndExpand(s, pointer1, pointer2)

            if (nextPalindrome.length > longestPalindromeInWindow.length) {
                longestPalindromeInWindow = nextPalindrome
            }
            pointer1++
            pointer2++
        }
        return longestPalindromeInWindow
    }

    private fun checkPalindromeAndExpand(
        s: String,
        pointer1: Int,
        pointer2: Int,
        beforePalindrome: String = "",
    ): String {
        if (pointer1 < 0) return beforePalindrome
        if (pointer2 > s.length - 1) return beforePalindrome

        val targetString = s.substring(pointer1, pointer2)
        if (targetString.isPalindrome()) {
            return checkPalindromeAndExpand(s, pointer1 - 1, pointer2 + 1, targetString)
        }
        return beforePalindrome
    }

    fun String.isPalindrome(): Boolean = (this == this.reversed())
}