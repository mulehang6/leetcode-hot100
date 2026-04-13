package hash.leetcode128;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 128 最长连续序列
 * <p>
 * 例如：
 * 输入：nums = [100,4,200,1,3,2]<p>
 * 输出：4<p>
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。<p>
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (Integer i : set) {
            // 如果i不是序列起点，直接跳过
            // 因为如果i-1在集合中，那么此序列的起点至少是i-1开始的
            if (set.contains(i - 1)) {
                continue;
            }

            // 能继续到这里，就说明i是起点
            int j = i + 1;
            while (set.contains(j)) {
                j++;
            }
            // 循环结束后，j-1是最后一个在集合内的元素，j-1到x一共有j-x个元素
            res = Math.max(res, j - i);
        }
        return res;
    }
}
