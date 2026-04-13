package hash.leetcode49;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 力扣49，字母异位词分组
 * <p>字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，
 * 并使用所有原字母一次。例如：
 * <p>输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * <p>
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 解释：
 * <p>
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。</p>
 */
public class Solution {

    /**
     * 思路：给每个字符串排序，排序后一样的是同一组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] sortedS = str.toCharArray();
            Arrays.sort(sortedS);
            map.computeIfAbsent(new String(sortedS), list -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
        
        // stream写法
        /*return new ArrayList<>(
                Arrays.stream(strs)
                        .collect(Collectors.groupingBy(s -> {
                            char[] sortedS = s.toCharArray();
                            Arrays.sort(sortedS);
                            return new String(sortedS);
                        }))
                        .values()
        );*/
    }
}
