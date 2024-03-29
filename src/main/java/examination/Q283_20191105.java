package examination;

import java.util.Arrays;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/5.
 */
public class Q283_20191105 {

    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针


    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                }
                System.out.println(Arrays.toString(nums));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

