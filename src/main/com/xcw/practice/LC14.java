package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-05-28
 */
public class LC14 {

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","d"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String firstWord = strs[0];
        String ret = "";
        here:
        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || firstWord.charAt(i) != strs[j].charAt(i)) {
                    break here;
                }
            }
            ret += String.valueOf(firstWord.charAt(i));
        }
        return ret;
    }
}
