package examination;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/7.
 */
public class Q11_20191107 {
    static class Solution {
        public int maxArea(int[] height) {
            int result = 0;
            for (int i = 0,j = height.length - 1; i < j;) {
                int h = height[i] < height[j] ? height[i++] : height[j--];
                int area = h * (j - i + 1);
                if (area > result) result = area;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] h = new int[]{1,8};
        System.out.println(solution.maxArea(h));
    }
}
