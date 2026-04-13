package slidingwindow.leetcode438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode第438题
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] countP = new int[26];// 统计p中各个字母的出现情况
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        int[] countS = new int[26];// 统计s的长为p.length字串中各个字符的出现情况
        for (int right = 0; right < s.length(); right++) {
            countS[s.charAt(right) - 'a']++;// 右端点字符进入
            int left = right - p.length() + 1;
            // 不足以形成子串
            if (left < 0) {
                continue;
            }

            if (Arrays.equals(countP, countS)) {
                res.add(left);
            }
            countS[s.charAt(left) - 'a']--;// 左端点离开
        }


        return res;
    }
}
