package examination;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/14.
 */
public class Q189_20191114 {

    static class Solution {
        public void rotate1(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                int prve = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    int temp = nums[j];
                    nums[j] = prve;
                    prve = temp;
                }
            }
        }

        public void rotate2(int[] nums, int k) {
            int[] nums_new = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int target = i + k >= nums.length ? (i + k) % nums.length : i + k;
                nums_new[target] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums_new[i];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate1(nums, 3);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1,2,3,4,5,6,7};
        solution.rotate2(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        System.out.println("this is main:" + Thread.currentThread().getName());
        CompletableFuture future = CompletableFuture.runAsync(() -> System.out.println("this is run async thread name:" + Thread.currentThread().getName()));

        future.thenRun(() -> System.out.println("this is compose thread name:" + Thread.currentThread().getName()));
    }
}
