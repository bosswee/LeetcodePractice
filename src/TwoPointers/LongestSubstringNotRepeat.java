package TwoPointers;

import java.util.HashMap;

/**
 * Created by Wee on 2015/4/1.
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringNotRepeat {
    public int lengthOfLongestSubstring(String s) {
        //两个指针确定max,用hashmap存储数据
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);//如果在后面发现前面的数相同指针就不后移了
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);

        }
        return max;
    }
}

