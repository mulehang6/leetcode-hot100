package hash.leetcode128

import kotlin.math.max

class SolutionKotlin {
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            set.add(num)
        }

        var res = 0
        for (num in set) {
            if (set.contains(num - 1)) continue

            var right = num + 1
            while (set.contains(right)) right++

            res = max(res, right - num)
        }
        return res
    }
}