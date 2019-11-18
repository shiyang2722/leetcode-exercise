package examination;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/18.
 */
public class Q509_20191118 {
    static class Solution {
        Map<Integer, Integer> cache = new HashMap<>();
        public int fib(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;

            Integer n1 = cache.get(n - 1) == null ? fib(n - 1) : cache.get(n - 1);
            Integer n2 = cache.get(n - 2) == null ? fib(n - 2) : cache.get(n - 2);
            Integer result = n1 + n2;
            cache.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(4));
    }
}
