package examination;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/16.
 */
public class Q1_20191116 {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.get(target - nums[i]) != null) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
