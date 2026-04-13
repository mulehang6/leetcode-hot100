package doubleptr.leetcode42;

/**
 * 力扣42
 */
public class Solution {
    public int trap(int[] height) {
        int res = 0;
        int preMax = 0;// 前缀最大值
        int sufMax = 0;// 后缀最大值
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);

            if (preMax < sufMax) {
                res += preMax - height[left];
                left++;
            } else {
                res += sufMax - height[right];
                right--;
            }
        }
        return res;
    }
}
