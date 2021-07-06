package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-04-29
 */
public class LC7 {

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }


    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
        }
        return result;
    }


}
