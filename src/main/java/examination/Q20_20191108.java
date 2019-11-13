package examination;

import java.util.*;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/8.
 */
public class Q20_20191108 {
    static class Solution {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        Solution() {
            map.put('}', '{');
            map.put(')', '(');
            map.put(']', '[');
        }
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == '{' || aChar == '(' || aChar == '[') {
                    stack.push(aChar);
                } else {
                    Character ex = stack.pop();
                    if (ex != map.get(aChar)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isValid1(String s) {
            if (s.length() == 1) return false;
            char[] chars = s.toCharArray();
            int j = 0;
            for (int i = 1; i < s.length(); i++) {
                j = i - 1;
                char c = chars[i];
                char c1 = chars[j];
                if (c == '}') {
                    if (c1 != '{') {
                        return false;
                    }
                } else if (c == ']') {
                    if (c1 != '[') {
                        return false;
                    }
                } else if (c == ')') {
                    if (c1 != '(') {
                        return false;
                    }
                } else {
                    continue;
                }
                if (j == 0 && i == s.length() - 1) return true;
                j --;
//                chars[i] = 0;
//                chars[i - 1] = 0;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid1("()[]{}"));
        System.out.println(solution.isValid1("(]"));
        System.out.println(solution.isValid1("([)]"));
        System.out.println(solution.isValid1("{[]}"));
    }
}
