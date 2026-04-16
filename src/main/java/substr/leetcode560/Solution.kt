package substr.leetcode560

/**
 * 力扣 560
 *
 * 给你一个整数数组 `nums` 和一个整数 `k` ，请你统计并返回 该数组中和为 `k` 的子数组的个数 。
 */
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val preSum = IntArray(nums.size + 1)
        for (i in nums.indices) {
            preSum[i + 1] = preSum[i] + nums[i]
        }

        val count = HashMap<Int, Int>(nums.size + 1)
        var res = 0
        // 子数组的和 = k => s[j] - s[i] = k
        for (i in nums.indices) {
            val x = k - preSum[i]
            res += count.getOrDefault(x, 0)
            count[nums[i]] = count.getOrDefault(nums[i], 0)
        }

        return res
    }
}