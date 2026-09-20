package slidingwindow

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    if (k <= 1) return 0
    var res = 0
    var left = 0
    var prod = 1

    for (right in nums.indices) {
        prod *= nums[right]

        while (prod >= k) {
            prod /= nums[left]
            left++
        }

        res += right - left + 1 // 确认题目要求为连续子数组
    }
    return res
}