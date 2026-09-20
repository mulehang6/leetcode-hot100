package doubleptr.leetcode42

import kotlin.math.max
import kotlin.math.min

class SolutionKotlin {

    /**
     * 解法一：前后缀分解
     */
    fun trap1(height: IntArray): Int {
        val preMax = IntArray(height.size)
        preMax[0] = height.first()
        for (i in 1..height.lastIndex) {
            preMax[i] = max(preMax[i - 1], height[i])
        }

        val sufMax = IntArray(height.size)
        sufMax[sufMax.lastIndex] = height.last()
        for (i in height.lastIndex - 1 downTo 0) {
            sufMax[i] = max(sufMax[i + 1], height[i])
        }

        var res = 0
        for (i in height.indices) {
            res += min(preMax[i], sufMax[i]) - height[i]
        }

        return res
    }

    /**
     * 解法2：相向双指针
     */
    fun trap2(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var res = 0
        var preMax = height.first()
        var sufMax = height.last()

        while (left <= right) {
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