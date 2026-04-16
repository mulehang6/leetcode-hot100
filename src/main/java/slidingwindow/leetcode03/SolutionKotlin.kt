package slidingwindow.leetcode03

import kotlin.math.max

class SolutionKotlin {
    fun lengthOfLongestSubstring(s: String): Int {
        var res = 0
        var left = 0
        val count = HashMap<Char, Int>()
        for (right in s.indices) {
            val c = s[right]
            count[c] = count.getOrDefault(c, 0) + 1

            // 只要还有重复字符，就移动左指针
            while (count[c]!! > 1) {
                count[s[left]] = count[s[left]]!! - 1
                left++
            }

            res = max(res, right - left + 1)
        }

        return res
    }
}