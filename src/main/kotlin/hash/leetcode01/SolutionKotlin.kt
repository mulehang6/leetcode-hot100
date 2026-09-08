package hash.leetcode01

/**
 * kotlin 实现
 */
class SolutionKotlin {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val x = nums[i]
            val remain = target - x

            if (map.containsKey(remain)) {
                return intArrayOf(map[remain]!!, i)
            }
            map[x] = i
        }
        return nums
    }
}