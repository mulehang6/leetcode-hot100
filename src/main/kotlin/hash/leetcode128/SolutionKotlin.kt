package hash.leetcode128

import kotlin.math.max

class SolutionKotlin {
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            set.add(num)
        }

        var res = 0
        for (element in set) {
            if (set.contains(element - 1)) continue

            var right = element + 1
            while (set.contains(right)) right++

            res = max(res, right - element)
        }
        return res
    }
}