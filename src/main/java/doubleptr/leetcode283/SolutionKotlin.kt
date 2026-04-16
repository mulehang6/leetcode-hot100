package doubleptr.leetcode283

class SolutionKotlin {
    fun moveZeroes(nums: IntArray): Unit {
        var i0 = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                val t = nums[i0]
                nums[i0] = nums[i]
                nums[i] = t
                i0++
            }
        }
    }
}