package com.xcw.practice;

import java.util.Arrays;

/**
 * @author wangxuechao
 * @date 2021-08-20
 */
public class LC541 {

    public static void main(String[] args) {
        System.out.println(reverseStr("abcd",2));
    }

    public static String reverseStr(String s, int k) {

        int len = s.length();
        int factor = len / (2 * k);
        int digit = len % (2 * k);
        char[] arr = s.toCharArray();
        if(digit > 0 && digit < k) {
            reverse(arr,len - digit ,len - 1);
        }
        if(digit >= k) {
            reverse(arr,len - digit,len - digit + k - 1);
        }
        for (int i = 0; i < factor; i++) {
            reverse(arr, 2 * i * k, 2 * i * k + k -1);
        }

        return new StringBuilder().append(arr).toString();
    }

    public static char[] reverse(char[] c, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char ch = c[startIndex];
            c[startIndex] = c[endIndex];
            c[endIndex] = ch;
            startIndex++;
            endIndex--;
        }
        return c;
    }
}
