package doubleptr

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = mutableListOf<List<Int>>()
    for (i in 0 until nums.lastIndex - 1) {
        val x = nums[i]
        var left = i + 1
        var right = nums.lastIndex

        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        if (x + nums[i + 1] + nums[i + 2] > 0) {
            break
        }

        if (x + nums.last() + nums[nums.lastIndex - 1] < 0) {
            continue
        }

        while (left < right) {
            val sum = x + nums[left] + nums[right]
            if (sum < 0) {
                left++
            } else if (sum > 0) {
                right--
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
