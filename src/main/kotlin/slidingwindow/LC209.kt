package slidingwindow

import kotlin.math.min

/**
 * none 此题目并不是hot 100中的
 */
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var res = nums.size + 1
    var left = 0
    var sum = 0

    for (right in nums.indices) {
        sum += nums[right]

        while (sum - nums[left] >= target) {
            sum -= nums[left]
            left++
        }

        if (sum >= target) {
            res = min(res, right - left + 1)
        }
    }
    return if (res <= nums.size) res else 0
}