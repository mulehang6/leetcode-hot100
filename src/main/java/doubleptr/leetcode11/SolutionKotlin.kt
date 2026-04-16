package doubleptr.leetcode11

import kotlin.math.max
import kotlin.math.min

class SolutionKotlin {
    fun maxArea(height: IntArray): Int {
        var res = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            val area = (right - left) * min(height[left], height[right])
            res = max(res, area)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res
    }
}