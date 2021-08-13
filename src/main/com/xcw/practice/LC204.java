package com.xcw.practice;

import java.util.Arrays;

/**
 * @author wangxuechao
 * @date 2021-08-12
 */
public class LC204 {

    public static void main(String[] args) {
        System.out.println(countPrimes1(2));

    }

    public static int countPrimes(int n) {

        if (n < 3) return 0;
        int ret = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrimes(i)) {
                ret++;
            }
        }
        return ret;
    }

    public static boolean isPrimes(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int countPrimes1(int n) {

        if (n < 3) return 0;
        int ret = 0;

        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);


        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ret++;
                if((long) i * i >= n) {
                    continue;
                }
                // i * i 可能会溢出为负数或者小于j的数
                for (int j = i * i; j < n ; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        return ret;
    }

}
