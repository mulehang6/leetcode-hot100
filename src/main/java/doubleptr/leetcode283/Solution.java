package doubleptr.leetcode283;


/**
 * 力扣283，移动0
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        /*List<Integer> list = new LinkedList<>();
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                list.add(num);
            }
        }

        for (int i = 0; i < count; i++) {
            list.add(0);
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }*/

        // 双指针
        int i0 = 0;// 表示下一个应该放非0元素的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[i0];
                nums[i0] = nums[i];
                nums[i] = t;
                i0++;
            }
        }
    }
}
