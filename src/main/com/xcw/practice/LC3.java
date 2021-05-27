package com.xcw.practice;


import java.util.*;

/**
 * @author wangxuechao
 * @date 2021-05-14
 */
public class LC3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba"));
    }


    public static int lengthOfLongestSubstring(String s) {

        Map map = new HashMap(s.length());
        int index = 0;
        int max = 0;
        int start = 0;
        while (index < s.length()) {
            if (!map.containsKey(s.charAt(index))) {
                map.put(s.charAt(index), index);
                index++;
            } else {
                start++;
                index = start;
                max = map.size() >= max ? map.size() : max;
                map = new HashMap();
            }
        }
        return max = max > map.size() ? max : map.size();
    }


    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap(s.length());
        int index = 0;
        int max = 0;
        int start = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (map.containsKey(ch)) {
                // +1 是将开始位置往后 +1
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, index - start + 1);
            map.put(s.charAt(index), index);
            index++;
        }
        return max;
    }
}
