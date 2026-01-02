package ch06

class P6_1 {
    fun isPalindrome(string: String): Boolean {
        val alphanumericString = string.filter { it.isLetterOrDigit() }
        val reversed = alphanumericString.reversed()
        /*
        java 에서는?
        new StringBuilder(string).reverse().toString();
         */

        println("string = $string")
        println("alphanumericString = $alphanumericString")
        println("reversed = $reversed")

        return string.lowercase() == reversed.lowercase()
    }

    fun isPalindrome2(string: String): Boolean {
        val alphanumericString = string.filter { it.isLetterOrDigit() }
        var pointer1 = 0
        var pointer2 = alphanumericString.length - 1
        var result = true;

        while (pointer1 <= pointer2) {
            val c1 = alphanumericString.get(pointer1).lowercase()
            val c2 = alphanumericString.get(pointer2).lowercase()
            if (c1 != c2) {
                result = false
                break
            }
            pointer1++
            pointer2--
        }
        return result
    }

    fun isPalindrome3(string: String): Boolean {
        val alphanumericString = string.filter { it.isLetterOrDigit() }

        val reversed = buildString {
            for (c in alphanumericString) {
                insert(0, c)
            }
        }

        println("string = $string")
        println("alphanumericString = $alphanumericString")
        println("reversed = $reversed")

        return string.lowercase() == reversed.lowercase()
    }
}