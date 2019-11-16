package examination;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/16.
 */
public class Q49_20191116 {


    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                char[] cs = str.toCharArray();
                Arrays.sort(cs);
                String key = new String(cs);

                if (!map.containsKey(key)) {
                    List<String> list = new ArrayList<>();
                    map.put(key, list);
                }
                map.get(key).add(str);

            }
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(x -> x.forEach(y -> System.out.print(y + " ")));
        solution.groupAnagrams(new String[]{"tea","","eat","","tea",""}).forEach(x -> x.forEach(y -> System.out.print(y + " ")));
    }


}
