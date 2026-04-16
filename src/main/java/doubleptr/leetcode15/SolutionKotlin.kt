package doubleptr.leetcode15

class SolutionKotlin {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        for (i in 0..<nums.size - 2) {
            val x = nums[i]
            var left = i + 1
            var right = nums.size - 1

            // 跳过重复数字
            if (i > 0 && nums[i - 1] == x) {
                continue
            }

            // 优化一，因为是已经排过序了
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break
            }

            // 优化二
            if (x + nums[nums.size - 2] + nums[nums.size - 1] < 0) {
                continue
            }

            while (left < right) {
                val sum = x + nums[left] + nums[right]
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++
                } else {
                    res.add(listOf(x, nums[left], nums[right]))
                    // 两个去重
                    do {
                        left++
                    } while (left < right && nums[left] == nums[left - 1])

                    do {
                        right--
                    } while (left < right && nums[right] == nums[right + 1])
                }
            }
        }
        return res
    }
}