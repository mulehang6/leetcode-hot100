package doubleptr.leetcode42

import kotlin.math.max

class SolutionKotlin {
    fun trap(height: IntArray): Int {
        var res = 0
        var left = 0
        var right = height.size - 1
        var preMax = 0
        var sufMax = 0

        while (left < right) {
            preMax = max(preMax, height[left])
            sufMax = max(sufMax, height[right])

            if (preMax < sufMax) {
                res += preMax - height[left]
                left++
            } else {
                res += sufMax - height[right]
                right--
            }
        }

        return res
    }
}