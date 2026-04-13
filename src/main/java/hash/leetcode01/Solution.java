package hash.leetcode01;


import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和，力扣第一题
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if (map.containsKey(target - x)) {
                // 返回下标
                return new int[] {map.get(target - x), i};
            }

            map.put(x, i);
        }

        return nums;
    }
}
