package doubleptr.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            int left = i + 1;
            int right = n - 1;

            // 此时已排序
            // 跳过重复数字
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }

            // 优化1：如果x + nums[i + 1] + nums[i + 2] > 0，那么直接break，因为之后的肯定都 > 0 了
            // 这里break是因为之后的i都不用试了
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            // 优化2：如果x + (nums[n - 2] + nums[n - 1])，即加上最大的两个数，都 < 0，那么之后的肯定都 < 0 了，直接continue
            // 这里continue是因为后续的i还有可能满足要求
            if (x + nums[n - 2] + nums[n - 1] < 0) {
                continue;
            }

            while (left < right) {
                if (x + nums[left] + nums[right] < 0) {
                    left++;
                } else if (x + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    res.add(List.of(x, nums[left], nums[right]));
                    // 两个去重，先移动指针，再拿移动后和移动前的做对比
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);

                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                }
            }
        }
        return res;
    }
}
