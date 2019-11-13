package examination;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/7.
 */
public class Q70_20191107 {
    static class Solution {
        public int climbStairs(int n) {
            if (n <= 2) return n;
            int pre1 = 2;
            int pre2 = 1;
            int sum = 0;
            for (int i = 3; i <= n; i++) {
                sum = pre1 + pre2;
                pre2 = pre1;
                pre1 = sum;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
    }
}
