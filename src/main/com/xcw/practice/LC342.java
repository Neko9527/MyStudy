package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-05-31
 */
public class LC342 {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println( i + " "+isPowerOfFour2(i));
        }
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 0) {
            if(n == 1) {
                return true;
            }
            if(n % 4 != 0) {
                return false;
            }
            n = n >> 2;
        }
        return false;
    }

    public static boolean isPowerOfFour1(int n) {
        // n & (n-1)
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public static boolean isPowerOfFour2(int n) {
        // n & (n-1)
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
