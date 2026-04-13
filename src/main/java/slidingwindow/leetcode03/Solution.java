package slidingwindow.leetcode03;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode第三题
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int left = 0;
        Map<Character, Integer> count = new HashMap<>();
        // 枚举右端点
        for (int right = 0; right < s.length(); right++) {
            char c = chars[right];
            count.put(c, count.getOrDefault(c, 0) + 1);

            // 只要还有重复字符
            while (count.get(c) > 1) {
                count.put(chars[left], count.get(chars[left]) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
