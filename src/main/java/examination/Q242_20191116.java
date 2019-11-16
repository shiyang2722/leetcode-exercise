package examination;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/16.
 */
public class Q242_20191116 {

    static class Solution {
        public boolean isAnagram(String s, String t) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);

            char[] tc = t.toCharArray();
            Arrays.sort(tc);

            if (sc.length != tc.length) return false;
            for (int i = 0; i < sc.length; i++) {
                if (sc[i] != tc[i]) return false;
            }
            return true;
        }
        public boolean isAnagram1(String s, String t) {
            if (t.length() != s.length()) return false;
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            int[] dict = new int[26];
            for (int i = 0; i < sc.length; i++) {
                dict[sc[i] - 'a'] ++;
                dict[tc[i] - 'a'] --;
            }

            for (int i = 0; i < dict.length; i++) {
                if (dict[i] != 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram1("anagram", "nagaram"));
        System.out.println(solution.isAnagram1("rat", "car"));
    }
}
