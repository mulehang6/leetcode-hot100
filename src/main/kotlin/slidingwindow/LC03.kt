package slidingwindow

import kotlin.math.max

fun lengthOfLongestSubstring(s: String): Int {
    var res = 0
    var left = 0
    val charArray = s.toCharArray()
    val map = mutableMapOf<Char, Int>()
    for (right in charArray.indices) {
        val char = charArray[right]
        map[char] = (map[char] ?: 0) + 1

        while (map[char]!! > 1) {
            map[charArray[left]] = map[charArray[left]]!! - 1
            left++
        }
        res = max(res, right - left + 1)
    }
    return res
}