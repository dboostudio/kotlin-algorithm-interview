package ch07

class P7_12 {

    fun maxProfit(prices: IntArray): Int {
        var min = 10000
        var max = 0
        var maxProfit = 0

        for (i in prices.indices) {
            val price = prices[i]
            if (price > max) {
                max = price
            }
            if (price < min) {
                min = price
                max = 0
            }
            val profit = max - min
            if (maxProfit < profit) maxProfit = profit
        }

        return maxProfit
    }

    fun maxProfit2(prices: IntArray): Int {
        var smallest = prices[0]
        var maProfit = 0
        for (i in prices.indices) {
            val price = prices[i]
            if (price < smallest) smallest = price
            val profit = price - smallest
            maProfit = maxOf(profit, maProfit)
        }
        return maProfit
    }
}