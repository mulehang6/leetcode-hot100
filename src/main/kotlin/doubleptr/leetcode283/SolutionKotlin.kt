package doubleptr.leetcode283

class SolutionKotlin {
    fun moveZeroes(nums: IntArray) {
        var start = 0 // 0元素的下标索引

        for (i in nums.indices) {
            if (nums[i] != 0) {
                val t = nums[i]
                nums[i] = nums[start]
                nums[start] = t
                start++
            }
        }
    }
}