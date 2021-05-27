package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-05-27
 */
public class LC9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(212));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        long ret = 0;
        int tmp = x;
        while (tmp != 0) {
            ret = ret * 10 + tmp % 10;
            tmp /= 10;
        }
        return ret == x;
    }
}
