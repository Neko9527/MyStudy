package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-08-17
 */
public class LC551 {

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {

//        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");

        if(s.contains("LLL"))return false;
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') {
                a++;
            }
            if(a >= 2)return false;
        }
        return false;
    }
}
