package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-07-07
 */
public class LC1897 {

    public static void main(String[] args) {
        String[] str = {"ab","aabc","bc"};
        System.out.println(makeEqual(str));
    }

    public static boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        for (int i = 0; i < words.length; i++) {
            char[] crr = words[i].toCharArray();
            for (char c : crr) {
                arr[c - 'a']++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
