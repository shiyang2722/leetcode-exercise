package examination;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/14.
 */
public class Q26_20191114 {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i;
        }
    }
}
